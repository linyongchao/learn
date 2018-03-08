package my.learn.blockchain.modal;

/**
 * 区块链中每一个块的数据模型
 * 
 * @author lin
 * @date 2018年3月7日 上午11:48:36
 */
public class Block {
	/**
	 * 块在链中的位置
	 */
	private long index;
	/**
	 * 块生成的时间
	 */
	private String timestamp;
	/**
	 * 块中存储的内容
	 */
	private String context;
	/**
	 * 块的Hash值
	 */
	private String hash;
	/**
	 * 上一个块的Hash值
	 */
	private String preHash;

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPreHash() {
		return preHash;
	}

	public void setPreHash(String preHash) {
		this.preHash = preHash;
	}

}
