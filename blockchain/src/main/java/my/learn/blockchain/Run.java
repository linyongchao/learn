package my.learn.blockchain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import my.learn.blockchain.modal.Block;
import my.learn.blockchain.modal.Chain;
import my.learn.blockchain.modal.Message;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * web服务入口
 * 
 * @author lin
 * @date 2018年3月8日 上午10:56:22
 */
public class Run {

	public static void main(String[] args) {
		/**
		 * 构造创世块
		 */
		Block genesisBlock = new Block();
		genesisBlock.setIndex(0);
		genesisBlock.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		genesisBlock.setContext("2018-03-08 i learn blockchain");
		genesisBlock.setPreHash("");
		genesisBlock.setHash(Chain.getHash(genesisBlock));
		Chain.add(genesisBlock);

		final Gson gson = new GsonBuilder().setPrettyPrinting().create();

		/**
		 * 定义get请求，返回整个链
		 */
		Spark.get("/", new Route() {
			public Object handle(Request request, Response response) throws Exception {
				return gson.toJson(Chain.getChain());
			}
		});

		/**
		 * 定义post请求，向链中新增一个块
		 */
		Spark.post("/", new Route() {
			public Object handle(Request request, Response response) throws Exception {
				String body = request.body();
				Message message = gson.fromJson(body, Message.class);
				if (message == null) {
					return "context is null";
				}
				String context = message.getContext();
				Block lastBlock = Chain.getLastBlock();
				Block newBlock = Chain.getBlock(lastBlock, context);
				if (Chain.isBlockValid(newBlock, lastBlock)) {
					Chain.add(newBlock);
					return "success";
				}
				return "HTTP 500: Invalid Block Error";
			}
		});
	}
}
