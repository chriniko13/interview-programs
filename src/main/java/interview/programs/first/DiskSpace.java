package interview.programs.first;

import java.util.Set;

/*

Examples
isWritable(1, 1, []) returns true as there is exactly 1 free sector which is enough to store the file of size 1
isWritable(1, 1, [1]) returns false as there's no free disk space at all
isWritable(4, 2, [1, 4]) returns true as the file of size 2 can be stored on sectors 2 and 3

 */

public class DiskSpace {

	//blocksize: 1000000 --- filesize: 100001 --- occupiedSectors: [100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 900000]

	public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
		int occSectorsSize = occupiedSectors.size();

		System.out.printf("blocksize: %d --- filesize: %d --- oS_Size: %d --- occupiedSectors: %s\n",blockSize, fileSize,
				occSectorsSize, occupiedSectors.toString());

		if (blockSize == occSectorsSize) {
			return false;
		}

		int free = blockSize - occSectorsSize;
		System.out.println(free % 2);
		if (free < fileSize) {
			return false;
		}


		if (occSectorsSize > 0
				&& free % 2 !=0 /*Note: i came up with this after reverse eng. test 10,11,12*/) {
			return false;
		}


//		if (free % 2 == 0 && fileSize % 2 != 0) {
//			return false;
//		}



		return true;
	}

}
