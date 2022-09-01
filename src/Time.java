import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Time {

	public static void main(String[] args) {
		
		String textContent = "#aaa bbb　#ccc";
		String textContent2 = "#aaa bbb　#ccc";
		for (int i = 1; i <= 300000 ; i ++ ) {
			textContent = textContent + textContent2;
		}
		final String textContent3 = textContent;
		
		//Stream処理の開始時間(順列)
		long startStream = System.nanoTime();
		
		String[] splits = textContent3.split("#");

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

//		System.out.println("Stream出力結果：" + splitList);
		
		//Stream処理の終了時間(順列)
        long endStream = System.nanoTime();
        System.out.println("【順列】Stream処理時間(ミリ秒)：" + (endStream - startStream) / 1000000f + "ms");
		
        System.out.println("--------------------------------");
        
        //Stream処理の開始時間(並列)
      	long startStream2 = System.nanoTime();

      	String[] splits2 = textContent3.split("#");

      	List<String> splitList2 = Arrays.stream(splits2).parallel()
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

//      System.out.println("Stream出力結果：" + splitList2);
      		
      	//Stream処理の終了時間(並列)
        long endStream2 = System.nanoTime();
        System.out.println("【並列】Stream処理時間(ミリ秒)：" + (endStream2 - startStream2) / 1000000f + "ms");
      		
        System.out.println("--------------------------------");
        
        //for処理の開始時間
      	long startFor = System.nanoTime();
      	
		String[] splits3 = textContent3.split("#");
		
		List<String> splitList3 = new ArrayList<>();

			for (String split : splits3) {
				int index = 0;
				if (split.contains(" ")) {
					index = split.indexOf(" ");
					split = split.substring(0, index);
				}
				if (split.contains("　")) {
					index = split.indexOf("　");
					split = split.substring(0, index);
				}
				if (split.contains("\n")) {
					index = split.indexOf("\n");
					split = split.substring(0, index);
				}
				if (split.contains("\t")) {
					index = split.indexOf("\t");
					split = split.substring(0, index);
				}
				if (!(split.equals(""))) {
					splitList3.add(split);
				}
			}
			
//		System.out.println("For出力結果：" + splitList3);
			
		//For処理の終了時間
	    long endFor = System.nanoTime();
	    System.out.println("For処理時間(ミリ秒)：" + (endFor - startFor) / 1000000f + "ms");
	}
}
