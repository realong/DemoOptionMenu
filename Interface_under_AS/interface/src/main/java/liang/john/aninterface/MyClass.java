package liang.john.aninterface;




/////////////////////////////////�U���O�C���������ӳ����P//////////////////////////////////////////

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
        System.out.println("���s�Q���F");
    }

    @Override
    public void OnLongPress(int seconds) {
        System.out.println("���s�Q���F" + seconds + "��");
    }
}

/*
class real_reactor2 implements  OnClickListener{

    @Override
    public void OnClick() {
        System.out.println("���ּ���....");
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
        //////�ĤG�����s//////////
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
                System.out.println("���ּ���....");
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
                System.out.println("���ּ���....");
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

                              // Player���Ѽƥ����O: �@��mp3�����ɮק@����"��Ƭy"
                              // ��Ƭy: stream (�]��I/O)--> ����: 1.�i�J�{��==>InputStream 2.���}�{��==>OutputStream
                              // ��Ƭy�bjava�����@�j�a�ڤu��!!���O�i�H�A���U���U�˪����p,�A�i�H�D�A�X�A���ӥ�
                              // ���Ҥ��� : FileInputStream ( �ۤϪ�FileOutputStream) �H�ɮ׬���H���y
                              // �ɥR: java��"�y"�a�ڤj���������o�o�Ӽˤl XxxxInputStream/XxxxOutputStream

                              FileInputStream fis;
                              fis = new FileInputStream("C:\\Lei music\\01 - Livin' On A Prayer.mp3");
                              sound  = new Player(fis);


                              System.out.println("���R���P���Ѽ���....");
                              sound.play();

                              //java�����~�a�ڳ����o�o�Ӽˤl XxxException
                          } catch (FileNotFoundException ex) {
                              /////�Ĥ@��catch���B�z fis = new FileInputStream("C:\\john_music\\sun.mp3");
                              /////�o�ص{���X�i��X�����~�O FileNotFoundException
                              System.out.println("�X���F:���~�O" + ex);
                          } catch (JavaLayerException ex) {
                              /////�ĤG��catch���B�z sound  = new Player(fis);
                              /////�o�ص{���X�i��X�����~�O JavaLayerException
                              System.out.println("�X���F:�ĤT��u��X��!!");
                          }

            }

            @Override
            public void OnLongPress(int seconds) {

            }
        };
    }
}
