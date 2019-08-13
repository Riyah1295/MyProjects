public class Crypto {
    public static void main(String[] args){
        //To take in the string.
        //String text = "Hithere" ;
        //String text = "abcd efghijklmnopqrstuvwxyz" ;
        String text = "This is some \"really\" great. (Text)!?" ;
        System.out.println("Plain Text: " + text);

        //To call normalizeText & normalize the text.
        String normalText = normalizeText(text);
        System.out.println("Normalized Text: " + normalText);

        //To call obify & make the text harder to read.
        String obifyText = obify(normalText);
        System.out.println("Obified Text: " + obifyText);

        //To call caesarify & caesar cipher the text.
        String caesarText = caesarify(obifyText,1);
        System.out.println("Caesar Text: " + caesarText);

        //To call the groupify & group the text.
        String grpText = groupify(caesarText,5);
        System.out.println("Group Text: " + grpText);

        //To call the encryptString & encrypt the text.
        String encryptText = encryptString(grpText,2,5);
        System.out.println("Encrypt Text: " + encryptText);
    }

    public static String normalizeText(String text){
        //To remove spaces, special characters & change to uppercase from text
        String rText = text.replaceAll("[^a-zA-Z]","");
        String upText = rText.toUpperCase();

        return upText;
    }

    public static String obify(String text){
        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'Y'};
        String obifiedText = "";
        int len = text.length();
        for (int i = 0; i < len; i++){
            char index = text.charAt(i);
            if(compare(index, vowels)){
                obifiedText += "OB" + index;
            }
            else {
                obifiedText += index;
            }
        }
        return obifiedText;
    }

   public static String caesarify(String text, int sValue){
        //String to char array
       String caesarText = "";
       //To find the length of the text.
       int len = text.length();
       for (int i = 0; i <len; i++){
           //Convert to ASCII & shift.
           int convertToAscii = text.charAt(i) + sValue;
           //A = ASCII(65)
           if(convertToAscii < 65){
               convertToAscii += 26;
           }
           //Z = ASCII(90)
           if(convertToAscii > 90){
               convertToAscii -= 26;
           }
           caesarText += (char) convertToAscii;
       }

        return caesarText;
    }

    public static String groupify(String text, int numOfGrp){
        //letterGroup --> number of letter per group.
        if(numOfGrp == 0){
            return text;
        }
        //To find the total length of the text.
        String groupifiedText = "";
        int len = text.length();
        int iter = 0;
        String space = "";
        for (int i = 0; i < len; i++){
            char textIndex = text.charAt(i);
            if (iter == numOfGrp){
                groupifiedText += " ";
                iter = 0;
                space = "";
            }
            groupifiedText += textIndex;
            iter++;
            space += textIndex;
        }
        //To add additional 'x' for odd number of total length of the text.
        if (space.length() != numOfGrp){
            for(int i = space.length(); i < numOfGrp; i++){
                groupifiedText += 'x';
            }
        }
        return groupifiedText;
    }

    public static boolean compare(char index, char[] array){
       //To compare the character with the character in the array.
        int len = array.length;
       for(int i = 0; i < len; i++){
           if(index == array[i]){
               return true;
           }
       }
       return false;
    }

    public static String encryptString(String text, int sValue, int grpSize){
        //text --> is the plain text.
        //sValue --> is the number of shift.
        //grpSize --> is the number of characters per group.
        //return --> the encrypted string.
        String normalText = normalizeText(text);
        String obifyText = obify(normalText);
        String caesarText = caesarify(obifyText,sValue);
        return groupify(caesarText, grpSize);
    }

}
