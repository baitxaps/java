package cn.huse.proxy;

//真实角色     目标
public class Target implements ITarget {

	@Override
	public void show() {
		System.out.println("show.....");
	}

}
