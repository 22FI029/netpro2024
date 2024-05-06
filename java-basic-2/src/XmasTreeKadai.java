public class XmasTreeKadai {

	public static void main(String[] args) {
		
            System.out.println("----step2-----");
            int n=10;//ツリーの高さ
            int m=7;//幹の高さ
            int s=3;//幹の幅

            for(int j=0;j<n;j++){

                for(int i=0;i<=n-j;i++){
                    if((i+j)%2==1){
                    System.out.print("@");
                    }else{
                        System.out.print(" ");
                    }
                }

            for(int i=0;i<=j*2;i++){
                System.out.print("*");
            }


            for(int i=0;i<=n-j;i++){
                if((i+j)%2==0){
                System.out.print(" @");
                }
            }


                System.out.print("\n");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n + s; j++) {
                if (j >= 4- s / 2 ) {
                    System.out.print("|");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");

    }

}
}
