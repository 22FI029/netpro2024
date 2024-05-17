public class DinnerFullCource {

    private Dish[] list = new Dish[5];// [0]-[4]の計5個
    public static void main(String[] args) {

		DinnerFullCource fullcourse = new DinnerFullCource();
		fullcourse.eatAll();
    }

    public DinnerFullCource(){
        list[0]  = new Dish();
		list[0] .setName("アボカドと本マグロのサラダ");
		list[0] .setValune(500);

        list[1] = new Dish();
		list[1].setName("国産小麦を使ったバケット");
		list[1].setValune(300);
		
		list[2] = new Dish();
		list[2].setName("ウニのクリームパスタ");
		list[2].setValune(1200);

        list[3] = new Dish();
		list[3].setName("羊のステーキ");
		list[3].setValune(1500);

        list[4] = new Dish();
		list[4].setName("自家製パンナコッタ");
		list[4].setValune(700);
		
        
    }
    public void eatAll() {
        // for文を用いて配列の中身を表示
        System.out.println("本日のコースは");
        for (Dish dish : list) {
            System.out.println(dish.getName() + ", Price: " + dish.getValune());
        }
        System.out.println("の計5品、4200円です");
    }

    
}