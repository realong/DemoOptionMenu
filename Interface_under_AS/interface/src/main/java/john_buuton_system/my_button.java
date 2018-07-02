package john_buuton_system;

import java.util.Scanner;



public class my_button{
    ///砞璸....
    ///砆矪瞶璶!!


    int seconds_be_pressed = 0; ////矗ㄑOnLongPress把计

    public OnClickListener reactor; ////才砏は莱(跑计)

    /*
    //// virtual code ---> ぃ才祘Αゅ猭!才и祘Α琜篶ゅ(パ)
    if(秙砆){

        reactor.OnClick();
    }

     if(秙砆盽){

        reactor.OnLongPress(seconds_be_pressed);
    }
    */
    /////盢virtual code 陆亩眏ΘタΑ祘Α絏

    protected my_button(){

        final Scanner sss = new Scanner(System.in);
        new Thread(){
            @Override
            public void run() {
                while(true){

                    System.out.print("瞷琌或ㄆン(0: exit, 1:click, 2:long press)");
                    int event = sss.nextInt();
                    if(event == 1){
                        reactor.OnClick();
                    }else if(event == 2){
                        System.out.print("ê碭");
                        int second = sss.nextInt();
                        reactor.OnLongPress(second);
                    }else if(event == 0){
                        break;
                    }
                }
            }
        }.start();

    }
}
