package mainPackage;

public interface AbstractCommand {
    boolean isNeedArg();
    boolean isNeedOrganization();
    String getTypeOfArg();
    String getName();
}
