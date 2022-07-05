package core;

public class Branch {
    /**
     * This is a tree branch object v.01
     *
     * @athor Tuspring
     */
    private int length, width;
    private final String treeType;
    private static final String MATERIAL = "organic";
    public int kappa = 10;


    private static class Bug {
        private static int a = 1;

        private static final int getA() {
            return a;
        }

        private static final void increaseA() {
            System.out.println();
            a++;
        }
    }

    public Branch(int length, int width, String treeType) {
        this.treeType = treeType;
        this.length = length;
        this.width = width;
    }

    public Branch(int length, int width) {
        this(length, width, "Not identified");
    }

    private Branch() {
        treeType = "Error";
    }

    public static String getMaterial() {
        return MATERIAL;
    }

}
