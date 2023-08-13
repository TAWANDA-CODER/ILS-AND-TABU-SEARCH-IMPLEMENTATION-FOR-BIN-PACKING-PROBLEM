import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class ProblemInstance {
    public String name;
    public int items_count;
    public int max_bin_Size;
    public int known_optimum;
    public int local_optimum; 
    public ArrayList<items> ItemsList = new ArrayList<>();

    public ProblemInstance(String name)
    {
        this.name = name;
    }

    public ProblemInstance() {
    }

    public int count_number_of_bins()
    {
        int number_of_bins = 1;
        int curr_bin_size = 0;
        
        for (int i = 0; i < ItemsList.size(); i++) 
        {
            if (curr_bin_size + ItemsList.get(i).value < max_bin_Size) 
            {
                curr_bin_size += ItemsList.get(i).value; 
            }
            else
            {
                number_of_bins++;
                curr_bin_size = 0;
                curr_bin_size += ItemsList.get(i).value;
            }
            
        }

        return number_of_bins;
    }

    public void ILS()
    {
        //FIRST FIT ALGORITHM
        local_optimum = count_number_of_bins();
        // System.out.println("Problem Instance Name :  " + name);
        // System.out.println("Items Count :  " + items_count);

        for (int i = 0; i < 2500; i++) 
        {
            Random rand = new Random();
            int int_randomx = rand.nextInt(items_count); 
            int int_randomy = rand.nextInt(items_count); 
            swap(int_randomx, int_randomy);
            if (count_number_of_bins() < local_optimum) 
            {
                local_optimum = count_number_of_bins();
            }
                
        }

        
    }

    public void Tabu()
    {
        //FIRST FIT ALGORITHM
        local_optimum = count_number_of_bins();

        LinkedList<ArrayList<items>> tabu_list = new LinkedList<>();
        int maxSize = 10;

        for (int i = 0; i < 2500; i++) 
        {
            Random rand = new Random();
            int int_randomx = rand.nextInt(items_count); 
            int int_randomy = rand.nextInt(items_count); 
            swap(int_randomx, int_randomy);

            Boolean exists_in_tabu_list = false;

            for(int x = 0; x < tabu_list.size();x++)
            {
                if(tabu_list.get(x).equals(ItemsList))
                {
                    exists_in_tabu_list = true;
                }
            }
            if (!exists_in_tabu_list) 
            {

                tabu_list.add(ItemsList);
                if (tabu_list.size() > maxSize) 
                {
                    tabu_list.removeFirst();    
                }

                if (count_number_of_bins() < local_optimum) 
                {
                    local_optimum = count_number_of_bins();
                }
                
            }
           
                
        }

    }

    public void swap(int x,int y)
    {
        items temp = new items(ItemsList.get(y).value);
        ItemsList.get(y).value = ItemsList.get(x).value;
        ItemsList.get(x).value = temp.value;
    }
    
}
