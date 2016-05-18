package true123.cn.utils;

/**
 * Created by Administrator on 16-5-18.
 */
public class FileUtils {

    /**
     * Convert the size to KB, MB or GB
     * @param size
     * @return
     */
    public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb <<10;
        long gb = mb <<10;

        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else
            return String.format("%d B", size);
    }

    /**
     * If the suffix is one of "BMP", "JPG", "GIF", "PNG", "DID", "JPEG", "JPE",
     "TIF", "TIFF", we treat is as picture.
     * Only check file suffix, do not check the file content
     * @param fileName
     * @return
     */
    public static boolean isPicFile(String fileName) {
        if (null == fileName || "".equals(fileName.trim())
                || fileName.lastIndexOf(".") <= 0) {
            return false;
        }
        String[] images = { "BMP", "JPG", "GIF", "PNG", "DID", "JPEG", "JPE",
                "TIF", "TIFF" };
        int dotIndex = fileName.lastIndexOf(".");
        String suffix = fileName.substring(dotIndex + 1);
        for (String image : images) {
            if (image.equalsIgnoreCase(suffix)) {
                return true;
            }
        }
        return false;
    }
}
