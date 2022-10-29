package Day57;
import java.util.*;

public final class FileFilterSystem {
    //Single filter condition
    public List<File> filter(List<File> files, FileFilter fileFilter) {
        //LinkedList in the DOC won't work
        List<File> res = new ArrayList<>();
        if (files == null || files.size() == 0) {
            return res;
        }
        for (File f : files) {
            if (fileFilter.filter(f)) {
                res.add(f);
            }
        }
        return res;
    }

    //combo filter conditions
    public List<File> filter(List<File> files, FilterTreeNode root) {
        //LinkedList in the DOC won't work
        List<File> res = new ArrayList<>();
        if (files == null || files.size() == 0) {
            return res;
        }
        for (File f : files) {
            if (root.eval(f)) {
                res.add(f);
            }
        }
        return res;
    }
    private void printFiles(List<File> files) {
        for (File file : files) {
            System.out.println(file);
        }
    }

    public static void main(String[] args) {
        FileFilterSystem fileFilterSystem = new FileFilterSystem();

        File a = new File(500, "Andyjpg16", "jpg", " Andy");
        File b = new File(200, "Britsjpg17", "jpg", "Brits");
        File c = new File(500, "Collintxt15", "txt", "Collin");
        File d = new File(300, "Divapdf20", "pdf", "Diva");

        List<File> files = Arrays.asList(a, b, c, d);

        //test single file filter
        System.out.println("--------test single file filter--------");
        FilterParameter fileParam = FilterParameter.createFromSize(500);
        SizeFilter sizeFilter = new SizeFilter(fileParam);

        List<File> res1 = fileFilterSystem.filter(files, sizeFilter);
        fileFilterSystem.printFiles(res1);

        //test file filter combo
        System.out.println("\n--------test file filter combo--------");

        AndFilterTreeOperator andOptr = new AndFilterTreeOperator();
        OrFilterTreeOperator orOptr = new OrFilterTreeOperator();

        FilterParameter fileParamSize500 = FilterParameter.createFromSize(500);
        SizeFilter sizeFilter500 = new SizeFilter(fileParamSize500);
        FileFilter creatorFilterAndy = new CreatorFilter(FilterParameter.createFromCreator("Andy"));

        FilterTreeNode node3 = new FilterTreeNode(sizeFilter500);
        FilterTreeNode node4 = new FilterTreeNode(creatorFilterAndy);
        FilterTreeNode node1 = new FilterTreeNode(andOptr, node3, node4);

        TypeFilter typeFilter = new TypeFilter(FilterParameter.createFromType("pdf"));

        FilterTreeNode node2 = new FilterTreeNode(typeFilter);
        FilterTreeNode root = new FilterTreeNode(orOptr, node1, node2);

        List<File> res2 = fileFilterSystem.filter(files, root);
        fileFilterSystem.printFiles(res2);
    }

}

abstract class FileFilter {
    private FilterParameter filterParam;

    public FileFilter(FilterParameter filterParam) {
        this.filterParam = filterParam;
    }

    abstract boolean filter(File file);

    public FilterParameter getFilterParameter() {
        return this.filterParam;
    }
}

final class SizeFilter extends FileFilter {
    public SizeFilter(FilterParameter filterParam) {
        super(filterParam);
    }
    @Override
    public boolean filter(File file) {
        return file.getSize() == this.getFilterParameter().getSize();
    }
}

final class NameFilter extends FileFilter {
    public NameFilter(FilterParameter filterParam) {
        super(filterParam);
    }
    @Override
    public boolean filter(File file) {
        return file.getName().equals(this.getFilterParameter().getName());
    }
}

final class TypeFilter extends FileFilter {
    public TypeFilter(FilterParameter filterParam) {
        super(filterParam);
    }
    @Override
    public boolean filter(File file) {
        return file.getType().equals(this.getFilterParameter().getType());
    }
}

final class CreatorFilter extends FileFilter {
    public CreatorFilter(FilterParameter filterParam) {
        super(filterParam);
    }
    @Override
    public boolean filter(File file) {
        return file.getCreator().equals(this.getFilterParameter().getCreator());
    }
}

final class FilterParameter {
    private Integer size;
    private String name;
    private String type;
    private String creator;

    private FilterParameter(Integer size, String name, String type, String creator) {
        this.size = size;
        this.name = name;
        this.type =type;
        this.creator = creator;
    }

    public static FilterParameter createFromSize(int size) {
        return new FilterParameter(size, null, null, null);
    }

    public static FilterParameter createFromName(String name) {
        return new FilterParameter(null, name, null, null);
    }

    public static FilterParameter createFromType(String type) {
        return new FilterParameter(null, null, type, null);
    }

    public static FilterParameter createFromCreator(String creator) {
        return new FilterParameter(null, null, null, creator);
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCreator() {
        return creator;
    }
}

class FilterTreeNode {
    private final FileFilter fileFilter;
    private final FilterTreeOperator operator;
    private final FilterTreeNode left;
    private final FilterTreeNode right;

    public FilterTreeNode(FileFilter fileFilter) {
        this.fileFilter = fileFilter;
        this.operator = null;
        this.left = null;
        this.right = null;
    }

    public FilterTreeNode(FilterTreeOperator operator, FilterTreeNode left, FilterTreeNode right) {
        this.fileFilter = null;
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public boolean eval(File file) {
        if (this.fileFilter != null) {
            return this.fileFilter.filter(file);
        }

        boolean left = this.left.eval(file);
        boolean right = this.right.eval(file);

        return this.operator.eval(left, right);
    }
}

interface FilterTreeOperator {
    boolean eval(boolean left, boolean right);
}

final class AndFilterTreeOperator implements FilterTreeOperator {
    @Override
    public boolean eval(boolean left, boolean right) {
        return left && right;
    }
}

final class OrFilterTreeOperator implements FilterTreeOperator {
    @Override
    public boolean eval(boolean left, boolean right) {
        return left || right;
    }
}

class File {
    private int size;
    private String name;
    private String type;
    private String creator;

    public File(int size, String name, String type, String creator) {
        this.size = size;
        this.name = name;
        this.type =type;
        this.creator = creator;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCreator() {
        return creator;
    }

    @Override
    public String toString() {
        return this.size + ", " + this.name + ", " + this.type + ", " + this.creator;
    }
}