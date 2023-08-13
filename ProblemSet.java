import java.util.ArrayList;

public class ProblemSet
{
    public String ProblemSetName;
    public ArrayList<ProblemInstance> ProblemInstances = new ArrayList<>();

    public ProblemSet(String ProblemSetName)
    {
        this.ProblemSetName = ProblemSetName;
    }
}