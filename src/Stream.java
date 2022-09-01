import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
		
		String textContent = "#aaa bbb　#ccc";
		// 「#」で文字列を分割
		String[] splits = textContent.split("#");

		// Streamで各条件に一致した単語は不要部分を捨ててリストに入れなおす
		List<String> splitList = Arrays.stream(splits)
							.map((s) -> {
								if (s.contains("\n")) {
									return s = s.substring(0, s.indexOf("\n"));
								} else if (s.contains("\t")) {
									return s = s.substring(0, s.indexOf("\t"));
								} else if (s.contains(" ")) {
									return s = s.substring(0, s.indexOf(" "));
								} else if (s.contains("　")) {
									return s = s.substring(0, s.indexOf("　"));
								} else {
									return s;
								}
							})
							.filter(s -> !(s.equals("")))
							.collect(Collectors.toList());
		
		// 抽出した単語はrepositoryに送る
//		for (String split : splitList) {
//			if(articleRepository.FindByTagContent(split).size() == 0 || articleRepository.FindByTagContent(split) == null) {
//				articleRepository.insertTag(split);
//			}
//		}

		System.out.println(splitList);

	}
}
