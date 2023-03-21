package second;

import java.util.Arrays;

/*
    Класс воспроизводящего устройства
    Поля: тип(название) и список поддерживаемых носителей
    Может воспроизводить песню с носителя и выводить его название, автора и название песни
*/

public class Player {
    private String type;
    private String[] supportedMedia;

    public Player(String type, String[] supportedMedia) {
        this.type = type;
        this.supportedMedia = supportedMedia;
    }

    public String getType() {
        return type;
    }

    public String[] getSupportedMedia() {
        return supportedMedia;
    }

    public void setSupportedMedia(String[] supportedMedia) {
        this.supportedMedia = supportedMedia;
    }

    public void play(Carrier carrier, Song song){
        //Проверка на возможность воспроизведения и вывод соответствующего сообщения
        if(Arrays.asList(supportedMedia).contains(carrier.getType())){
            System.out.println("Устройство: " + carrier.getType() + " Исполнитель: " + song.getAuthor() + " Песня: " + song.getName());
        }
        else {
            System.out.println("Устройство не может воспроизвести песню с данного носителя");
        }
    }
}
