package com.dm.hfmtree;

import java.util.*;

public class HuffmenTree {

	HfmNode root;

	/**
	 * 叶子节点
	 */
	List<HfmNode> leafs;

	/**
	 * 叶子节点的权重
	 */
	Map<Character, Integer> weights;

	/**
	 * 编码结果
	 */
	public static Map<Character, String> code;

	public HuffmenTree(Map<Character, Integer> weights) {
		this.weights = weights;
		leafs = new ArrayList<HfmNode>();
	}

	/**
	 * 编码
	 */
	public String decode(String str) {
		Map<Character, String> code = HuffmenTree.code;
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		for (char c : chars) {
			sb.append(code.get(c));
		}
		return sb.toString();
	}

	/**
	 * 解码
	 */
	public String encode(String decode) {
		char[] chars = decode.toCharArray();
		StringBuilder sb = new StringBuilder();
		String key = "";
		for (char c : chars) {
			key += c;
			for (Map.Entry<Character, String> entry : code.entrySet()) {
				if(entry.getValue().equals(key)){
					sb.append(entry.getKey());
					key = "";
				}
			}
		}

		return sb.toString();
	}

	/**
	 * 叶子节点进行编码
	 */
	public Map<Character, String> code() {

		Map<Character, String> map = new HashMap<Character, String>();
		for (HfmNode node : leafs) {
			String code = "";
			// 叶子节点肯定只有一个字符
			Character c = new Character(node.chars.charAt(0));
			// 只有一个点
			HfmNode current = node;
			do {
				// 说明当前点是左边
				if (current.parent != null && current == current.parent.left) {
					code = "0" + code;
				} else {
					code = "1" + code;
				}
				current = current.parent;
			// parent == null就表示到了根节点
			} while (current.parent != null);
			map.put(c, code);
			System.out.println(c + ":" + code);
		}
		return map;

	}

	public void creatTree() {
		// 拿出所有的点
		Character keys[] = weights.keySet().toArray(new Character[0]);
		// jdk底层的优先队列
		PriorityQueue<HfmNode> priorityQueue = new PriorityQueue<HfmNode>();
		for (Character c : keys) {
			HfmNode hfmNode = new HfmNode();
			hfmNode.chars = c.toString();
			// 权重
			hfmNode.fre = weights.get(c);
			// 首先把我们的优先队列初始化进去
			priorityQueue.add(hfmNode);
			leafs.add(hfmNode);
		}

		int len = priorityQueue.size();
		// 每次找最小的两个点合并
		for (int i = 1; i <= len - 1; i++) {
			// 每次取优先队列的前面两个 就一定是两个最小的
			HfmNode n1 = priorityQueue.poll();
			HfmNode n2 = priorityQueue.poll();

			HfmNode newNode = new HfmNode();
			// 我们把值赋值一下，也可以不复制
			newNode.chars = n1.chars + n2.chars;
			// 把权重相加
			newNode.fre = n1.fre + n2.fre;

			// 维护出树的结构
			newNode.left = n1;
			newNode.right = n2;
			n1.parent = newNode;
			n2.parent = newNode;

			priorityQueue.add(newNode);
		}
		// 最后这个点就是我们的根节点
		root = priorityQueue.poll();
		System.out.println("构建完成");
	}

	public static void main(String[] args) {
		// a:3 b:24 c:6 d:20 e:34 f:4 g:12
		Map<Character, Integer> weights = new HashMap<Character, Integer>();
		//一般来说：动态的加密，最开始是不知道里面有什么内容的。我们需要一个密码本，往往就是某个字典。如果是英文就用英文字典，统计次数。
		//换密码本
		//静态的文件。针对性的做编码.图像加密,没有特性的。hash加密（MD5）
		weights.put('a', 3);
		weights.put('b', 24);
		weights.put('c', 6);
		weights.put('d', 1);
		weights.put('e', 34);
		weights.put('f', 4);
		weights.put('g', 12);

		HuffmenTree huffmenTree = new HuffmenTree(weights);
		huffmenTree.creatTree();
		HuffmenTree.code = huffmenTree.code();
		String str = "aceg";
		System.out.println("编码后的：");
		String decode = huffmenTree.decode(str);
		System.out.println(decode);
		String encode = huffmenTree.encode(decode);
		System.out.println("解码后的：");
		System.out.println(encode);
		char s[] = str.toCharArray();
	}
/*
 a:10110
b:01
c:1010
d:00
e:11
f:10111
g:100

 * *
 */
}
