package john_buuton_system;

import java.util.Scanner;



public class my_button{
    ///�]�p....
    ///�Q���U���B�z�n�~�]!!


    int seconds_be_pressed = 0; ////����OnLongPress���Ѽ�

    public OnClickListener reactor; ////�ŧi�@�ӲŦX�W�檺������(�ܼ�)

    /*
    //// virtual code ---> ���ŦX�{����k!�����ŦX�ڵ{���[�c����r(�ۥ�)
    if(���s�Q���U){

        reactor.OnClick();
    }

     if(���s�Q�`��){

        reactor.OnLongPress(seconds_be_pressed);
    }
    */
    /////�Nvirtual code ½Ķ�[�j���������{���X

    protected my_button(){

        final Scanner sss = new Scanner(System.in);
        new Thread(){
            @Override
            public void run() {
                while(true){

                    System.out.print("�{�b�O�ƻ�ƥ�(0: exit, 1:click, 2:long press)");
                    int event = sss.nextInt();
                    if(event == 1){
                        reactor.OnClick();
                    }else if(event == 2){
                        System.out.print("�����F�X��");
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
