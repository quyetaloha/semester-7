
package demo;


public class Paragraph {
    public String normalText(String line) {
     String out = "";                             
     line = line.toLowerCase();
     line = line.replaceAll("\\s+", " ");
     line = line.replaceAll(" \\.", "\\.");
     line = line.replaceAll("\\.", "\\. ");
     line = line.replaceAll(" \\,", "\\,");
     line = line.replaceAll("\\,", "\\, ");
     line = line.replaceAll("\\s+", " ");
     line = line.trim();
     out=line;
     boolean isCap = true;
     char c;
     StringBuilder strb = new StringBuilder("");
     for (int i = 0; i < out.length()-1; i++) {
        c = out.charAt(i);
        if (c == '.') {
        isCap = true;
     }
     if (isCap && Character.isAlphabetic(c)) {
        c = Character.toUpperCase(c);
        isCap = false;
     }
     strb.append(c);
     }
     out = strb.toString();
     if (out.charAt(out.length()-1) != '.') {
     out = out + ".";
     }
     return out;
    }
}
