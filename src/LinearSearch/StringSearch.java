package LinearSearch;

import java.lang.reflect.Array;

public class StringSearch {
    public static void main(String[] args) {
        String s = "Sagar";
        char search = 's';

        //stringSearch(s, search);
        System.out.println(stringSearch(s, search));

        // printing each of element as a Char array
        for(char ele : s.toCharArray()){
            System.out.print(ele + ", ");
        }

    }

    static boolean stringSearch(String s, char search) {
        if(s.length() == 0){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            if(search == s.charAt(i)){ // iterating the loop using index number and getting the char using the CharAt() method and comparing them
                 return true;
            }
        }

        return false;
    }
}
