
public class Greeting {
    public static void main(final String[] args) {
        String str = "23511011501782351112179911801562340161171141148";
        int nums = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            nums = nums * 10 + (str.charAt(str.length()-1-i) - '0');
            if(nums >= 32 && nums <= 122) {
                System.out.println(nums);
                sb.append((char)nums);
                nums = 0;
            }
        }
        System.out.println(sb.toString());
    }
}