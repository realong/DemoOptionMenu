package liang.john.aninterface;




/////////////////////////////////下面是每次應用應該都不同//////////////////////////////////////////

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import john_buuton_system.ButtonFactory;
import john_buuton_system.OnClickListener;
import john_buuton_system.my_button;

class real_reactor implements OnClickListener {

    @Override
    public void OnClick() {
        System.out.println("按鈕被按了");
    }

    @Override
    public void OnLongPress(int seconds) {
        System.out.println("按鈕被按了" + seconds + "秒");
    }
}

/*
class real_reactor2 implements  OnClickListener{

    @Override
    public void OnClick() {
        System.out.println("音樂播放中....");
    }

    @Override
    public void OnLongPress(int seconds) {

    }
}
*/

public class MyClass {
    public static void main(String[] abc){


        //my_button b = new my_button();
        //real_reactor handler = new real_reactor();
        //b.reactor = handler;
        //////第二顆按鈕//////////
        /*
        my_button b2= new my_button();
        real_reactor2 handler2 = new real_reactor2();
        b2.reactor = handler2;
        */
        /*
        my_button b2= new my_button();
        b2.reactor = new OnClickListener() {
            @Override
            public void OnClick() {
                System.out.println("音樂播放中....");
            }

            @Override
            public void OnLongPress(int seconds) {

            }
        };
        */
        /*
        new my_button().reactor = new OnClickListener() {
            @Override
            public void OnClick() {
                System.out.println("音樂播放中....");
            }

            @Override
            public void OnLongPress(int seconds) {

            }
        };
        */
        //my_button b_from_factory = ButtonFactory.make_s();
        my_button b_from_factory = new ButtonFactory().make();
        //my_button b_from_factory = new my_button();
        b_from_factory.reactor = new OnClickListener() {
            @Override
            public void OnClick() {

                  try {
                              Player sound;

                              // Player的參數必須是: 一份mp3音樂檔案作成的"資料流"
                              // 資料流: stream (也有I/O)--> 分成: 1.進入程式==>InputStream 2.離開程式==>OutputStream
                              // 資料流在java中有一大家族工具!!分別可以適應各式各樣的狀況,你可以挑適合你的來用
                              // 本例介紹 : FileInputStream ( 相反的FileOutputStream) 以檔案為對象的流
                              // 補充: java的"流"家族大部分都長得這個樣子 XxxxInputStream/XxxxOutputStream

                              FileInputStream fis;
                              fis = new FileInputStream("C:\\Lei music\\01 - Livin' On A Prayer.mp3");
                              sound  = new Player(fis);


                              System.out.println("美麗的星期天播放中....");
                              sound.play();

                              //java的錯誤家族都長得這個樣子 XxxException
                          } catch (FileNotFoundException ex) {
                              /////第一個catch式處理 fis = new FileInputStream("C:\\john_music\\sun.mp3");
                              /////這種程式碼可能出的錯誤是 FileNotFoundException
                              System.out.println("出錯了:錯誤是" + ex);
                          } catch (JavaLayerException ex) {
                              /////第二個catch式處理 sound  = new Player(fis);
                              /////這種程式碼可能出的錯誤是 JavaLayerException
                              System.out.println("出錯了:第三方工具出錯!!");
                          }

            }

            @Override
            public void OnLongPress(int seconds) {

            }
        };
    }
}
