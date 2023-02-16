public class Text {


    public String Text(char language,String text){

        if(language == 'd'){
            de(text);
        }
        if(language == 'e'){
            en(text);
        }

        return text;
    }


    public String de(String text) {
        switch (text) {
            case "Start":
                return "Start";
            case "Einstellungen":
                return "Einstellungen";
            case "Beenden":
                return "Beenden";
            default:
                return "Error";
        }

    }
    public String en(String text){
        switch (text){
            case "Start":
                return "Play";
            case "Einstellungen":
                return "Settings";
            case "Beenden":
                return "Quit";
            default:
            return "Error";
        }
    }
}
