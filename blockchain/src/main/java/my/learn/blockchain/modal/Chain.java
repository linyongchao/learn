package my.learn.blockchain.modal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 链
 * 
 * @author lin
 * @date 2018年3月7日 下午6:53:46
 */
public class Chain {

	/**
	 * 代表整个链，存储所有块
	 */
	private static ArrayList<Block> chain = new ArrayList<Block>();

	/**
	 * 如果新链比当前链长，则采用新链
	 * 
	 * @param newChain
	 * @author lin
	 * @date 2018年3月8日 上午10:03:14
	 */
	public void replaceChain(ArrayList<Block> newChain) {
		if (newChain.size() > chain.size()) {
			chain = newChain;
		}
	}

	/**
	 * 计算一个块的Hash值
	 * 
	 * @param block
	 * @return
	 * @author lin
	 * @date 2018年3月7日 下午6:59:22
	 */
	public static String getHash(Block block) {
		String record = block.getIndex() + block.getTimestamp() + block.getContext() + block.getPreHash();
		return DigestUtils.sha256Hex(record);
	}

	/**
	 * 生成一个块
	 * 
	 * @param old
	 * @param context
	 * @return
	 * @author lin
	 * @date 2018年3月7日 下午7:03:13
	 */
	public static Block getBlock(Block old, String context) {
		Block block = new Block();
		block.setIndex(old.getIndex() + 1);
		block.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		block.setContext(context);
		block.setPreHash(old.getHash());
		block.setHash(getHash(block));
		return block;
	}

	/**
	 * 校验新块的合法性
	 * 
	 * @param newBlock
	 * @param oldBlock
	 * @return
	 * @author lin
	 * @date 2018年3月8日 上午9:59:59
	 */
	public static boolean isBlockValid(Block newBlock, Block oldBlock) {
		if (newBlock.getIndex() != oldBlock.getIndex() + 1) {
			return false;
		}
		if (!newBlock.getPreHash().equals(oldBlock.getHash())) {
			return false;
		}
		if (!getHash(newBlock).equals(newBlock.getHash())) {
			return false;
		}
		return true;
	}

	/**
	 * 获取最后一个块
	 * 
	 * @return
	 * @author lin
	 * @date 2018年3月8日 上午10:23:10
	 */
	public static Block getLastBlock() {
		return chain.get(chain.size() - 1);
	}

	/**
	 * 获取链的长度
	 * 
	 * @return
	 * @author lin
	 * @date 2018年3月8日 上午10:53:34
	 */
	public static int size() {
		return chain.size();
	}

	/**
	 * 向链中添加块
	 * 
	 * @param block
	 * @author lin
	 * @date 2018年3月8日 上午10:53:36
	 */
	public static void add(Block block) {
		chain.add(block);
	}

	/**
	 * 返回当前链
	 * 
	 * @return
	 * @author lin
	 * @date 2018年3月8日 上午10:55:10
	 */
	public static ArrayList<Block> getChain() {
		return chain;
	}

}
