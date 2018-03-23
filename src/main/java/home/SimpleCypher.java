package home;

public class SimpleCypher {
    public static void main(String[] args) {
        String java = "java";
        StringBuffer appender = new StringBuffer("Zaszyfrowany tekst to: ");
        char[] charArray = java.toCharArray();
        for (char aCharArray : charArray) {
            appender.append(aCharArray);
            encryptCharacter(appender, aCharArray);
        }
        System.out.println(appender);
    }

    private static void encryptCharacter(StringBuffer appender, char characterToEncrypt) {
        String inserted = shiftOneCharacterForward(characterToEncrypt);
        appender.replace(appender.length() - 1, appender.length(), inserted);
    }

    private static String shiftOneCharacterForward(char c) {
        return "" + (char) (c + 1);
    }
}
