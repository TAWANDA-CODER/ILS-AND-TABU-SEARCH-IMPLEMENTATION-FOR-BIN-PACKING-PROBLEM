import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class GetOptimums 
{
    ArrayList<DataSetOptimums> Optimum_Values =  new ArrayList<>();

    
    public void ReadExcelFile()
    {
        for(int i = 0; i < 9; i++)
        {
            try 
            {
                File myObj = null;
                switch(i)
                {
                  case 0:
                  {
                    myObj = new File("Optimum_Values/Falkenauer_T.txt");
                    Optimum_Values.add(new DataSetOptimums("Falkenauer_T"));
                    break;
                  }
                  case 1:
                  {
                    myObj = new File("Optimum_Values/Falkenauer_U.txt");
                    Optimum_Values.add(new DataSetOptimums("Falkenauer_U"));
                    break;
                  }
                  case 2:
                  {
                    myObj = new File("Optimum_Values/Hard28.txt");
                    Optimum_Values.add(new DataSetOptimums("Hard28"));
                    break;
                  }
                  case 3:
                  {
                    myObj = new File("Optimum_Values/Scholl_1.txt");
                    Optimum_Values.add(new DataSetOptimums("Scholl_1"));
                    break;
                  }
                  case 4:
                  {
                    myObj = new File("Optimum_Values/Scholl_2.txt");
                    Optimum_Values.add(new DataSetOptimums("Scholl_2"));
                    break;
                  }
                  case 5:
                  {
                    myObj = new File("Optimum_Values/Scholl_3.txt");
                    Optimum_Values.add(new DataSetOptimums("Scholl_3"));
                    break;
                  }
                  case 6:
                  {
                    myObj = new File("Optimum_Values/Schwerin_1.txt");
                    Optimum_Values.add(new DataSetOptimums("Schwerin_1"));
                    break;
                  }
                  case 7:
                  {
                    myObj = new File("Optimum_Values/Schwerin_2.txt");
                    Optimum_Values.add(new DataSetOptimums("Schwerin_2"));
                    break;
                  }
                  case 8:
                  {
                    myObj = new File("Optimum_Values/Wascher.txt");
                    Optimum_Values.add(new DataSetOptimums("Wascher"));
                    break;
                  }
                  
                }
                Scanner myReader = new Scanner(myObj);
                // System.out.println(Optimum_Values.get(i).Dataset_Name);
                while (myReader.hasNextLine()) {
                  String data = myReader.nextLine();
                  String[] strArray = null;  
                  strArray = data.split("\\s+");
                  Optimum_Values.get(i).ProblemInstances.add(new OptimumValues(strArray[0],Integer.parseInt(strArray[1])));
                }
                myReader.close();
              } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
        }
        
    }
}
