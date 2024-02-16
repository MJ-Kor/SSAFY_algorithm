package hw.day_01_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1244_김민주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 남학생 (a): 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꿈
		// => s_num = n*a
		// 여학생: 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꿈
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int switchNum = Integer.parseInt(br.readLine());
		int[] switches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		//System.out.println(Arrays.toString(switches));
		int studentNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			// 남학생일 경우 for문으로 배수인 인덱스를 찾아 변경
			if (gender == 1) {
				for (int j = 1; j <= switches.length; j++) {
					if(j % num == 0) {
						if (switches[j - 1] == 0) {
							switches[j - 1] = 1;
						}
						else {
							switches[j - 1] = 0;
						}
					}
				}
			}
			
			// 여학생일 경우 받은 숫자를 기준으로 양옆으로 한 칸씩 이동하며 해당 칸끼리의 스위치 상태가 같으면 변경
			else {
				int k = 1;
				if (switches[num - 1] == 0) {
					switches[num - 1] = 1;
				}
				else {
					switches[num - 1] = 0;
				}
				
				// 배열의 인덱스가 넘어가지 않도록 설정
				while(num - 1 + k < switchNum && num - 1 - k >= 0) {
					if(switches[num - 1 + k] == switches[num - 1 - k]) {
						if (switches[num - 1 + k] == 0) {
							switches[num - 1 + k] = 1;
							switches[num - 1 - k] = 1;
						}
						else {
							switches[num - 1 + k] = 0;
							switches[num - 1 - k] = 0;
						}
						k++;
					}
					else {
						break;
					}
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < switches.length; i++) {
			cnt++;
			System.out.print(switches[i] + " ");
			if(cnt % 20 == 0) {
				System.out.println();
			}
		}
	}

}
