package guichat;

//複数接続Socket通信サンプルプログラム(サーバー)
//クライアントからの接続を待ち、接続が行なわれたら
//1行のデータを受け取り、コンソールに表示して接続を切断する。
//複数のクライアントとの通信をスレッドにより行なう。
//プログラム終了は，コマンドプロンプトでCTRL-C

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class GUIAniMultiTCPServer2 {

    GUIAnimationMain animation;

    public GUIAniMultiTCPServer2(GUIAnimationMain animation) {
        this.animation = animation;
        System.out.println("server started:" + this.animation);
        System.out.println("creating srv socket");

        ServerSocket serverSoc = null;
        try {
            serverSoc = new ServerSocket(5000);
            boolean flag = true;
            System.out.println("Waiting for Connection. ");
            int thcounter = 0;
            while (flag) {
                Socket socket = null;
                socket = serverSoc.accept();
                new SrvWorkerThread(socket, thcounter++).start();
            }
        } catch (IOException e) {
            System.out.println("IOException!");
            e.printStackTrace();
        } finally {
            try {
                if (serverSoc != null) {
                    serverSoc.close();
                }
            } catch (IOException ioex) {
                ioex.printStackTrace();
            }
        }
    }

    class SrvWorkerThread extends Thread {
        private Socket soc;

        public SrvWorkerThread(Socket sct, int thcounter) {
            soc = sct;
            System.out.println("Thread " + thcounter + " is Generated.  Connect to " + soc.getInetAddress());
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                PrintWriter sendout = new PrintWriter(soc.getOutputStream(), true);
                String line;
                line = reader.readLine();
                System.out.println("Message from client :" + line);

                if (line.equals("end")) {
                    System.exit(1);
                }

                if (line.startsWith("face,color") && animation != null) {
                    String[] sline = line.split(",");
                    int which = Integer.parseInt(sline[2]);
                    String colorStr = sline[3];
                    Color c = Color.gray;
                    if (colorStr.equals("yellow")) {
                        c = Color.yellow;
                    } else if (colorStr.equals("red")) {
                        c = Color.red;
                    }
                    animation.setFaceColor(which, c);
                } else if (line.startsWith("face,place") && animation != null) {
                    String[] sline = line.split(",");
                    int which = Integer.parseInt(sline[2]);
                    int x = Integer.parseInt(sline[3]);
                    int y = Integer.parseInt(sline[4]);
                    animation.setFacePlace(which, x, y, line);
                } else if (line.startsWith("face,emotion") && animation != null) {
                    String[] sline = line.split(",");
                    int which = Integer.parseInt(sline[2]);
                    String emotion = sline[3];
                    animation.setFaceEmotion(which, emotion);
                }

                sendout.println("Message is received at Server. Thankyou! your message is [" + line + "]");

            } catch (IOException ioex) {
                ioex.printStackTrace();
            } finally {
                try {
                    if (soc != null) {
                        soc.close();
                    }
                } catch (IOException ioex) {
                    ioex.printStackTrace();
                }
            }
        }
    }
}
