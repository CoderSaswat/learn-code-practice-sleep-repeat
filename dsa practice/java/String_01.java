public class String_01 {
    public static void main(String[] args) {
//        f1();
        f2();
        f3();
    }



    //reverse string
    private static void f1() {
        String str = "Saswat";
        char[] strCharArr = str.toCharArray();
        for (int i = 0, j = strCharArr.length - 1; i < j; i++, j--) {
            char temp = strCharArr[i];
            strCharArr[i] = strCharArr[j];
            strCharArr[j] = temp;
        }
        System.out.println(new String(strCharArr));
    }

    public static boolean isPalindrom(String str){
        for (int i = 0, j= str.length()-1; i < j; i++,j--) {
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    //valid palindrom
    private static void f2() {
        String str = "abcbaa";
        System.out.println(isPalindrom(str));
    }

// length of longest substring of non-repeating character
    private static void f3() {
        String str = "saswat";
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                String temp = "";
//                temp = str.charAt(i);
            }
        }
    }
}