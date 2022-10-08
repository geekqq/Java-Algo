package Day37;
//import com.google.common.collect.ImmutableList;
import java.util.List;

//自定义一个immutable class

public class MyImmutable {
    private final int intVal;
    private final String str;
    private final boolean flag;
    //private final ImmutableList<String> immutableList;

    public MyImmutable(int intVal, String str, boolean flag, List<String> list) {
        this.intVal = intVal;
        this.str = str;
        this.flag = flag;
        //this.immutableList = ImmutableList.copuOf(list);
    }

    public int getInt() {
        return this.intVal;
    }

    public String getStr() {
        return this.str;
    }

    public boolean getFlag() {
        return this.flag;
    }
//    public ImmutableList<String> getList() {
//        return this.immutableList;
//    }
}
