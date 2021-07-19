public class Program {
    public static void main(String[] args) {
        String str = " ";
        findLengthOfLastWord(str);
    }

    public static void findLengthOfLastWord(String in) {
        String input =  in.trim();
        if(input.length() > 0 ) {
            String[] str = input.split(" ");
           
            String lastWord = str[str.length-1];
            lastWord.trim();
            System.out.println(lastWord.length());
        }
        System.out.println("not FOund");
    }
}