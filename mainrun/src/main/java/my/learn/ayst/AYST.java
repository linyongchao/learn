package my.learn.ayst;

public class AYST {
	private static String[][] init = new String[5][5];
	static {
		// 把确定的初始化进去
		init[0][0] = "挪威";
		init[2][0] = "英国";

		init[0][1] = "黄色";
		init[1][1] = "蓝色";
		init[2][1] = "红色";
		init[3][1] = "绿色";
		init[4][1] = "白色";

		init[1][2] = "马";

		init[2][3] = "牛奶";
		init[3][3] = "咖啡";

		init[0][4] = "顿山";
	}
	// 可选择的国家
	private static String[] countryName = { "德国", "瑞典", "丹麦" };
	// 可填充的位置
	private static int[] countryIndex = { 1, 3, 4 };

	private static String[] animalName = { "狗", "猫", "鸟", "鱼" };
	private static int[] animalIndex = { 0, 2, 3, 4 };

	private static String[] drinkName = { "啤酒", "茶", "水" };
	private static int[] drinkIndex = { 0, 1, 4 };

	private static String[] smokeName = { "王子", "蓝领", "波兰斯", "坡魔" };
	private static int[] smokeIndex = { 1, 2, 3, 4 };

	public static void main(String[] args) {
		for (int i = 0; i < countryIndex.length; i++) {
			int c = countryIndex[i];
			String country = countryName[i];
			init[c][0] = country;
			for (int j = 0; j < animalIndex.length; j++) {
				int a = animalIndex[j];
				String animal = animalName[j];
				init[a][2] = animal;
				if ((country.equals("瑞典") && !animal.equals("狗")) || (!country.equals("瑞典") && animal.equals("狗"))) {
					continue;
				}
				for (int m = 0; m < drinkIndex.length; m++) {
					int d = drinkIndex[m];
					String drink = drinkName[m];
					if ((country.equals("丹麦") && !drink.equals("茶")) || (!country.equals("丹麦") && drink.equals("茶"))) {
						continue;
					}
					init[d][3] = drink;
					for (int n = 0; n < smokeIndex.length; n++) {
						int s = smokeIndex[n];
						String smoke = smokeName[n];
						init[s][4] = smoke;
						if ((smoke.equals("坡魔") && !animal.equals("鸟"))
								|| (!smoke.equals("坡魔") && animal.equals("鸟"))) {
							continue;
						}
						if ((smoke.equals("蓝领") && !drink.equals("啤酒"))
								|| (!smoke.equals("蓝领") && drink.equals("啤酒"))) {
							continue;
						}
						if ((smoke.equals("王子") && !country.equals("德国"))
								|| (!smoke.equals("王子") && country.equals("德国"))) {
							continue;
						}
						if (smoke.equals("波兰斯") && animal.equals("猫") && Math.abs(s - a) != 1) {
							continue;
						}
						if (smoke.equals("波兰斯") && drink.equals("水") && Math.abs(s - a) != 1) {
							continue;
						}
						int count = 0;
						for (String[] string : init) {
							for (String string2 : string) {
								if (string2 == null) {
									count++;
								}
							}
						}
						if (count > 0) {
							continue;
						}
						for (int k = 0; k < 5; k++) {
							for (int q = 0; q < 5; q++) {
								System.out.print(init[q][k] + "\t");
							}
							System.out.println();
						}
						System.out.println("----");
					}
				}
			}
		}
		System.out.println("over");
	}

}
