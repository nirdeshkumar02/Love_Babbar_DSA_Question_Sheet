package String;
/*
Below are simple steps to find number of customers who could not get any computer.

1) Initialize result as 0.
2) Traverse the given sequence. While traversing, keep track of occupied computers (this can be done by keeping track of
characters which have appeared only once and a computer was available when they appeared). At any point, if count of
occupied computers is equal to ‘n’, and there is a new customer, increment result by 1.

The important thing is to keep track of existing customers in cafe in a way that can indicate whether the customer has got
a computer or not. Note that in sequence “ABCBCADEED”, customer ‘B’ did not get a seat, but still in cafe as a new customer
‘C’ is next in sequence.
 */
public class Function_to_find_Number_of_customers_who_could_not_get_a_computer {
    public static void main(String[] args){
        System.out.println(runCustomerSimulation(2, "ABBAJJKZKZ".toCharArray()));
        System.out.println(runCustomerSimulation(3, "GACCBDDBAGEE".toCharArray()));
        System.out.println(runCustomerSimulation(3, "GACCBGDDBAEE".toCharArray()));
        System.out.println(runCustomerSimulation(1, "ABCBCA".toCharArray()));
        System.out.println(runCustomerSimulation(1, "ABCBCADEED".toCharArray()));
    }

    static final int MAX_CHAR = 256;

    private static int runCustomerSimulation(int n, char []seq) {
        // seen[i] = 0, indicates that customer 'i' is not in cafe
        // seen[1] = 1, indicates that customer 'i' is in cafe but
        //         computer is not assigned yet.
        // seen[2] = 2, indicates that customer 'i' is in cafe and
        //         has occupied a computer.
        char []seen = new char[MAX_CHAR];

        // Initialize result which is number of customers who could
        // not get any computer.
        int res = 0;

        int occupied = 0; // To keep track of occupied computers

        // Traverse the input sequence
        for (int i=0; i< seq.length; i++)
        {
            // Find index of current character in seen[0...25]
            int ind = seq[i] - 'A';

            // If First occurrence of 'seq[i]'
            if (seen[ind] == 0)
            {
                // set the current character as seen
                seen[ind] = 1;

                // If number of occupied computers is less than
                // n, then assign a computer to new customer
                if (occupied < n)
                {
                    occupied++;

                    // Set the current character as occupying a computer
                    seen[ind] = 2;
                }

                // Else this customer cannot get a computer,
                // increment result
                else
                    res++;
            }

            // If this is second occurrence of 'seq[i]'
            else
            {

                // Decrement occupied only if this customer
                // was using a computer
                if (seen[ind] == 2)
                    occupied--;
                seen[ind] = 0;
            }
        }
        return res;
    }
}
