package my.learn.book.impl;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import my.learn.utils.FileTools;

public class DYBZExport {

	public static void analysis(String path) {
		List<String> list = FileTools.filetoList(new File(path));
		String regex = "^[a-z0-9A-Z【】\"<>/=\\s_.]+$";
		String between = "<img(.*?)\">";
		Pattern pattern = Pattern.compile(between);
		StringBuilder sBuilder = new StringBuilder();
		list.forEach(s -> {
			// 先替换掉需要替换的字符
			s = replace(s);
			// 然后拆分段落
			String[] line = s.split("</p>");
			for (String string : line) {
				if (string.matches(regex)) {
					continue;
				}
				if (StringUtils.isBlank(string)) {
					continue;
				}
				if (string.contains("C") && string.contains("M")) {
					continue;
				}
				if (string.contains("Ｃ") && string.contains("Ｍ")) {
					continue;
				}
				Matcher matcher = pattern.matcher(string);
				if (matcher.find()) {
					// 包含前后的两个字符
					System.out.println("s = s.replace(\"" + matcher.group().replace("\"", "\\\"") + "\", \"\");");
					System.out.println(string);
				}
				sBuilder.append(string).append("\r\n");
			}
		});
		new File(path).delete();
		FileTools.appendWrite(path, sBuilder.toString());
	}

	public static String replace(String s) {
		s = s.replace("<div>", "");
		s = s.replace("<center class=\"chapterPages\">", "");
		s = s.replace("</div>", "");
		s = s.replace("<p>", "");
		s = s.replace("<div>", "");
		s = s.replace("<img src=\"/toimg/data/ma3.png\">", "妈");
		s = s.replace("<img src=\"/toimg/data/ri.png\">", "日");
		s = s.replace("<img src=\"/toimg/data/xue.png\">", "学");
		s = s.replace("<img src=\"/toimg/data/xiong.png\">", "胸");
		s = s.replace("<img src=\"/toimg/data/xue2.png\">", "穴");
		s = s.replace("<img src=\"/toimg/data/nei.png\">", "内");
		s = s.replace("<img src=\"/toimg/data/cha.png\">", "插");
		s = s.replace("<img src=\"/toimg/data/se.png\">", "色");
		s = s.replace("<img src=\"/toimg/data/qin.png\">", "亲");
		s = s.replace("<img src=\"/toimg/data/qing.png\">", "情");
		s = s.replace("<img src=\"/toimg/data/wen.png\">", "温");
		s = s.replace("<img src=\"/toimg/data/cao.png\">", "操");
		s = s.replace("<img src=\"/toimg/data/si.png\">", "死");
		s = s.replace("<img src=\"/toimg/data/shu.png\">", "熟");
		s = s.replace("<img src=\"/toimg/data/jing2.png\">", "精");
		s = s.replace("<img src=\"/toimg/data/yin2.png\">", "阴");
		s = s.replace("<img src=\"/toimg/data/chun.png\">", "唇");
		s = s.replace("<img src=\"/toimg/data/tui.png\">", "腿");
		s = s.replace("<img src=\"/toimg/data/sha.png\">", "杀");
		s = s.replace("<img src=\"/toimg/data/ying.png\">", "硬");
		s = s.replace("<img src=\"/toimg/data/shen.png\">", "呻");
		s = s.replace("<img src=\"/toimg/data/yin.png\">", "吟");
		s = s.replace("<img src=\"/toimg/data/rou.png\">", "肉");
		s = s.replace("<img src=\"/toimg/data/bang.png\">", "棒");
		s = s.replace("<img src=\"/toimg/data/tun2.png\">", "吞");
		s = s.replace("<img src=\"/toimg/data/ai.png\">", "爱");
		s = s.replace("<img src=\"/toimg/data/yao.png\">", "摇");
		s = s.replace("<img src=\"/toimg/data/wei.png\">", "未");
		s = s.replace("<img src=\"/toimg/data/luan.png\">", "乱");
		s = s.replace("<img src=\"/toimg/data/di2.png\">", "弟");
		s = s.replace("<img src=\"/toimg/data/gao.png\">", "高");
		s = s.replace("<img src=\"/toimg/data/zuo.png\">", "做");
		s = s.replace("<img src=\"/toimg/data/ling.png\">", "凌");
		s = s.replace("<img src=\"/toimg/data/ji.png\">", "肌");
		s = s.replace("<img src=\"/toimg/data/gao2.png\">", "搞");
		s = s.replace("<img src=\"/toimg/data/xing.png\">", "性");
		s = s.replace("<img src=\"/toimg/data/tun.png\">", "臀");
		s = s.replace("<img src=\"/toimg/data/dan.png\">", "弹");
		s = s.replace("<img src=\"/toimg/data/liu.png\">", "流");
		s = s.replace("<img src=\"/toimg/data/tian.png\">", "舔");
		s = s.replace("<img src=\"/toimg/data/gan.png\">", "干");
		s = s.replace("<img src=\"/toimg/data/shui.png\">", "水");
		s = s.replace("<img src=\"/toimg/data/zhong.png\">", "中");
		s = s.replace("<img src=\"/toimg/data/mu.png\">", "母");
		s = s.replace("<img src=\"/toimg/data/pi.png\">", "屁");
		s = s.replace("<img src=\"/toimg/data/ji2.png\">", "鸡");
		s = s.replace("<img src=\"/toimg/data/lun.png\">", "伦");
		s = s.replace("<img src=\"/toimg/data/fen.png\">", "粉");
		s = s.replace("<img src=\"/toimg/data/zhu.png\">", "主");
		s = s.replace("<img src=\"/toimg/data/mei.png\">", "美");
		s = s.replace("<img src=\"/toimg/data/zhi.png\">", "指");
		s = s.replace("<img src=\"/toimg/data/jiao.png\">", "交");
		s = s.replace("<img src=\"/toimg/data/she.png\">", "舌");
		s = s.replace("<img src=\"/toimg/data/yin3.png\">", "淫");
		s = s.replace("<img src=\"/toimg/data/jiu.png\">", "九");
		s = s.replace("<img src=\"/toimg/data/suan.png\">", "酸");
		s = s.replace("<img src=\"/toimg/data/lu.png\">", "露");
		s = s.replace("<img src=\"/toimg/data/tou.png\">", "偷");
		s = s.replace("<img src=\"/toimg/data/tai.png\">", "台");
		s = s.replace("<img src=\"/toimg/data/chao.png\">", "潮");
		s = s.replace("<img src=\"/toimg/data/feng.png\">", "缝");
		s = s.replace("<img src=\"/toimg/data/shi2.png\">", "湿");
		s = s.replace("<img src=\"/toimg/data/ru2.png\">", "辱");
		s = s.replace("<img src=\"/toimg/data/gui.png\">", "龟");
		s = s.replace("<img src=\"/toimg/data/chu.png\">", "处");
		s = s.replace("<img src=\"/toimg/data/bao.png\">", "暴");
		s = s.replace("<img src=\"/toimg/data/zu.png\">", "足");
		s = s.replace("<img src=\"/toimg/data/ma2.png\">", "马");
		s = s.replace("<img src=\"/toimg/data/xi3.png\">", "吸");
		s = s.replace("<img src=\"/toimg/data/ji3.png\">", "纪");
		s = s.replace("<img src=\"/toimg/data/gou.png\">", "狗");
		s = s.replace("<img src=\"/toimg/data/gong.png\">", "共");
		s = s.replace("<img src=\"/toimg/data/ma.png\">", "麻");
		s = s.replace("<img src=\"/toimg/data/nen.png\">", "嫩");
		s = s.replace("<img src=\"/toimg/data/mi2.png\">", "蜜");
		s = s.replace("<img src=\"/toimg/data/jv2.png\">", "菊");
		s = s.replace("<img src=\"/toimg/data/dang2.png\">", "荡");
		s = s.replace("<img src=\"/toimg/data/yu.png\">", "欲");
		s = s.replace("<img src=\"/toimg/data/gong2.png\">", "宫");
		s = s.replace("<img src=\"/toimg/data/yi.png\">", "义");
		s = s.replace("<img src=\"/toimg/data/si2.png\">", "丝");
		s = s.replace("<img src=\"/toimg/data/xi2.png\">", "席");
		s = s.replace("<img src=\"/toimg/data/luo.png\">", "裸");
		s = s.replace("<img src=\"/toimg/data/guo.png\">", "国");
		s = s.replace("<img src=\"/toimg/data/she2.png\">", "射");
		s = s.replace("<img src=\"/toimg/data/hu.png\">", "胡");
		s = s.replace("<img src=\"/toimg/data/wang.png\">", "亡");
		s = s.replace("<img src=\"/toimg/data/ru.png\">", "乳");
		s = s.replace("<img src=\"/toimg/data/jian.png\">", "奸");
		s = s.replace("<img src=\"/toimg/data/jing.png\">", "茎");
		s = s.replace("<img src=\"/toimg/data/bang2.png\">", "帮");
		s = s.replace("<img src=\"/toimg/data/nu.png\">", "奴");
		s = s.replace("<img src=\"/toimg/data/qiang.png\">", "枪");
		s = s.replace("<img src=\"/toimg/data/xue3.png\">", "血");
		s = s.replace("<img src=\"/toimg/data/bi.png\">", "逼");
		s = s.replace("<img src=\"/toimg/data/zha.png\">", "炸");
		s = s.replace("<img src=\"/toimg/data/jie.png\">", "介");
		s = s.replace("<img src=\"/toimg/data/mie.png\">", "灭");
		s = s.replace("<img src=\"/toimg/data/dong.png\">", "洞");
		s = s.replace("<img src=\"/toimg/data/yao2.png\">", "药");
		s = s.replace("<img src=\"/toimg/data/lun2.png\">", "轮");
		s = s.replace("<img src=\"/toimg/data/jv.png\">", "具");
		s = s.replace("<img src=\"/toimg/data/you2.png\">", "幼");
		s = s.replace("<img src=\"/toimg/data/lu2.png\">", "撸");
		s = s.replace("<img src=\"/toimg/data/nue.png\">", "虐");
		s = s.replace("<img src=\"/toimg/data/sao.png\">", "骚");
		s = s.replace("<img src=\"/toimg/data/dan2.png\">", "蛋");
		s = s.replace("<img src=\"/toimg/data/han.png\">", "含");
		s = s.replace("<img src=\"/toimg/data/fu.png\">", "妇");
		s = s.replace("<img src=\"/toimg/data/nai.png\">", "奶");
		s = s.replace("<img src=\"/toimg/data/fu.png\">", "妇");
		s = s.replace("<img src=\"/toimg/data/pao.png\">", "炮");
		s = s.replace("<img src=\"/toimg/data/bo.png\">", "勃");
		s = s.replace("<img src=\"/toimg/data/keng.png\">", "坑");
		s = s.replace("<img src=\"/toimg/data/niao.png\">", "尿");
		s = s.replace("<img src=\"/toimg/data/jian2.png\">", "贱");
		s = s.replace("<img src=\"/toimg/data/du.png\">", "毒");
		s = s.replace("<img src=\"/toimg/data/ze.png\">", "泽");
		s = s.replace("<img src=\"/toimg/data/lou.png\">", "漏");
		s = s.replace("<img src=\"/toimg/data/ding.png\">", "丁");
		s = s.replace("<img src=\"/toimg/data/shou.png\">", "兽");
		s = s.replace("<img src=\"/toimg/data/tao.png\">", "涛");
		s = s.replace("<img src=\"/toimg/data/gun.png\">", "棍");
		s = s.replace("<img src=\"/toimg/data/fu2.png\">", "腐");
		s = s.replace("<img src=\"/toimg/data/mang.png\">", "氓");
		s = s.replace("<img src=\"/toimg/data/hui.png\">", "秽");
		s = s.replace("<img src=\"/toimg/data/peng.png\">", "鹏");
		s = s.replace("<img src=\"/toimg/data/mi.png\">", "咪");
		s = s.replace("<img src=\"/toimg/data/pao999.png\">", "剖");
		s = s.replace("<img src=\"/toimg/data/tong.png\">", "童");
		s = s.replace("<img src=\"/toimg/data/lu3.png\">", "颅");
		s = s.replace("<img src=\"/toimg/data/shi.png\">", "尸");
		s = s.replace("<img src=\"/toimg/data/zai.png\">", "宰");
		s = s.replace("<img src=\"/toimg/data/gang.png\">", "肛");
		s = s.replace("<img src=\"/toimg/data/ji4.png\">", "妓");
		s = s.replace("<img src=\"/toimg/data/du2.png\">", "杜");
		s = s.replace("<img src=\"/toimg/data/jin.png\">", "锦");
		return s;
	}

}
