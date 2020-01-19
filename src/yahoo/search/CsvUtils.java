
package yahoo.search;


import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CsvUtils {

    private  final char DEFAULT_SEPARATOR = ',';
    
    public  String writeLine(  String   value) throws IOException {
        return writeLine(  value, DEFAULT_SEPARATOR, ' ');
    }

    public  String writeLine(  String   value, char separators) throws IOException {
      return  writeLine(  value, separators, ' ');
    }

    //https://tools.ietf.org/html/rfc4180
    private  String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    public  String writeLine(  String   value, char separators, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }
        sb.append("\n");
         return sb.toString();

    }

}
