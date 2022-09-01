import java.util.ArrayList;
import java.util.List;

public class For {

	public static void main(String[] args) {
		String textContent = "#aaa bbb　#ccc";
		// 「#」で文字列を分割
		String[] splits = textContent.split("#");

		// 抽出した文字列を保管しておくリスト
		List<String> splitList = new ArrayList<>();

		// 既にDBに入っている文言がないかチェック
		for (String split : splits) {
			int index = 0;
			// 半角スペースがあったらそれまでの文字列を取得
			if (split.contains(" ")) {
				index = split.indexOf(" ");
				split = split.substring(0, index);
			}
			// 全角スペースがあったらそれまでの文字列を取得
			if (split.contains("　")) {
				index = split.indexOf("　");
				split = split.substring(0, index);
			}
			// 改行があったらそれまでの文字列を取得
			if (split.contains("\n")) {
				index = split.indexOf("\n");
				split = split.substring(0, index);
			}
			// タブがあったらそれまでの文字列を取得
			if (split.contains("\t")) {
				index = split.indexOf("\t");
				split = split.substring(0, index);
			}
//			//「#から始まって空白、改行を含まない文字列」はrepositoryに送る
//			if(articleRepository.FindByTagContent(split).size() == 0 || articleRepository.FindByTagContent(split) == null) {
//				articleRepository.insertTag(split);
//			}

			// 中身が空(#以外で始まったsplit)でない単語のみをリストに入れる
			if (!(split.equals(""))) {
				splitList.add(split);
			}
		}

		System.out.println(splitList);

	}
}
