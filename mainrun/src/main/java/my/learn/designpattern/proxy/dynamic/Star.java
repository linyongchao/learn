package my.learn.designpattern.proxy.dynamic;

public class Star implements IMovieStar, ISingerStar {
	private String name;

	public Star(String name) {
		this.name = name;
	}

	@Override
	public void movieShow(int money) {
		System.out.println(name + " 出演了部片酬 " + money + " 元的电影");
	}

	@Override
	public void tvShow(int money) {
		System.out.println(name + " 出演了部片酬 " + money + " 元的电视剧");
	}

	@Override
	public void sing(int number) {
		System.out.println(name + " 唱了 " + number + " 首歌");
	}

}
