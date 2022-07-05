package proj1;

public class EqualsHashcode {
    int aNum;
    EqualsHashcode(int a){
        aNum = a;
    }
    @Override
    public boolean equals(Object that){
        if (this == that) return true;
        if (that == null) return false;
        if (that.getClass() != getClass()) return false;

        EqualsHashcode tmpObj = (EqualsHashcode) that;
        if (this.aNum != tmpObj.aNum){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(aNum);
    }
}
