package Day212;

import java.util.List;

public class NRayTree {
    int val;
    List<NRayTree> children;

    public NRayTree() {};
    public NRayTree(int val) {
        this.val = val;
        children = null;
    }
}

