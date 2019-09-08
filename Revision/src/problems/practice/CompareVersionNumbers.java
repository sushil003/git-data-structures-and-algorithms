package problems.practice;

/**
 * 
 * @author Sushil
 *
 */
public class CompareVersionNumbers {

	public static void main(String[] args) {

		CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
		
		System.out.println(compareVersionNumbers.compareVersion("1.0", "1"));
	}

	public int compareVersion(String version1, String version2) {

		 if (version1.length() == 0 && version2.length() == 0) {
				return 0;
			}

			if (version1.length() == 0 && version2.length() != 0) {
				return -1;
			}

			if (version1.length() != 0 && version2.length() == 0) {
				return 1;
			}

			String[] ver1 = version1.split("\\.");

			String[] ver2 = version2.split("\\.");

			int ver1Ptr = 0;
			int ver2Ptr = 0;

			while (ver1Ptr < ver1.length && ver2Ptr < ver2.length) {

				int v1 = Integer.parseInt(ver1[ver1Ptr]);
				int v2 = Integer.parseInt(ver2[ver2Ptr]);

				if (v1 > v2) {
					return 1;
				} else if (v1 < v2) {
					return -1;
				} else {
					ver1Ptr++;
					ver2Ptr++;
				}
			}

			
				
				while(ver1Ptr < ver1.length ) {
	                int res = Integer.parseInt(ver1[ver1Ptr]);
					if(res>0) {
						return 1;
					}
					ver1Ptr++;
				}
			
				while(ver2Ptr < ver2.length ) {
	                int res = Integer.parseInt(ver2[ver2Ptr]);
					if(res > 0) {
						return -1;
					}
					ver2Ptr++;
					}
			

			return 0;
	}
}
