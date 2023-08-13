public class OptimumValues
{
    String Problem_Instance;
    Integer Known_Opt_Value;

    public  OptimumValues(String Problem_Instance,Integer Known_Opt_Value) {
        this.Problem_Instance = Problem_Instance;
        this.Known_Opt_Value = Known_Opt_Value;
    }

    public String getProblem_Instance()
    {
        return Problem_Instance;
    }

    public Integer getKnown_Opt_Value()
    {
        return Known_Opt_Value;
    }

}

