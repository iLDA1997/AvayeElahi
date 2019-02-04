package com.noobs_team.avayeelahi.Utils;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class CityDatabase extends SQLiteOpenHelper {

    private static String DB_PATH = "";
    private static String DB_NAME = "City";
    private Context mContext;
    private SQLiteDatabase mDataBase;

    public CityDatabase(Context context) {
        super(context, DB_NAME, null, 11);

        this.mContext = context;
        DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        createDataBase();
    }


    public ArrayList<String> getOstan() {
        ArrayList<String> arrayList = new ArrayList<String>();

        if (open()) {

            Cursor cursor = mDataBase.rawQuery("select name from province", null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                close();
            } else {

                do {

                    arrayList.add(cursor.getString(0));


                } while (cursor.moveToNext());

                cursor.close();
                close();
            }
        }
        return arrayList;
    }

    public ArrayList<String> getcity(int id) {
        ArrayList<String> arrayList = new ArrayList<String>();

        if (open()) {

            Cursor cursor = mDataBase.rawQuery("select name from city where province_id='" + id + "'", null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                close();
            } else {

                do {

                    arrayList.add(cursor.getString(0));


                } while (cursor.moveToNext());

                cursor.close();
                close();
            }
        }
        return arrayList;
    }

    public int getostanid(String name) {
        int id = 0;

        if (open()) {

            Cursor cursor = mDataBase.rawQuery("select id from province where name='" + name + "'", null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                close();
            } else {

                do {

                    id = (cursor.getInt(0));


                } while (cursor.moveToNext());

                cursor.close();
                close();
            }
        }
        return id;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }


    public boolean open() throws SQLException {
        try {
            String mPath = DB_PATH + DB_NAME;
            mDataBase = SQLiteDatabase.openDatabase(mPath, null,
                    SQLiteDatabase.CREATE_IF_NECESSARY);
            return mDataBase != null;
        } catch (Exception e) {
        }
        return false;
    }

    private void createDataBase() {

        try {
            boolean mDataBaseExist = checkDataBase();
            if (!mDataBaseExist) {
                this.getReadableDatabase();
                this.close();
                copyDataBase();
            }
        } catch (Exception e) {
        }
    }

    private void copyDataBase() {

        try {

            InputStream mInput = mContext.getAssets().open("City.db");
            String outFileName = DB_PATH + DB_NAME;
            OutputStream mOutput = new FileOutputStream(outFileName);
            byte[] mBuffer = new byte[1024];
            int mLength;
            while ((mLength = mInput.read(mBuffer)) > 0) {
                mOutput.write(mBuffer, 0, mLength);
            }
            mOutput.flush();
            mOutput.close();
            mInput.close();

        } catch (Exception e) {

        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS  city(" +
                "[id] [int] NOT NULL," +
                "[province_id] [int] NOT NULL," +
                "[name] varchar(200) NOT NULL)";
        db.execSQL(CREATE_TABLE);

        CREATE_TABLE = "INSERT INTO city ('id', 'province_id', 'name') VALUES" +
                "(1, 1, 'آذر شهر')," +
                "(2, 1, 'اسكو')," +
                "(3, 1, 'اهر')," +
                "(4, 1, 'بستان آباد')," +
                "(5, 1, 'بناب')," +
                "(6, 1, 'بندر شرفخانه')," +
                "(7, 1, 'تبريز')," +
                "(8, 1, 'تسوج')," +
                "(9, 1, 'جلفا')," +
                "(10, 1, 'سراب')," +
                "(11, 1, 'شبستر')," +
                "(12, 1, 'صوفیان')," +
                "(13, 1, 'عجبشير')," +
                "(14, 1, 'قره آغاج')," +
                "(15, 1, 'كليبر')," +
                "(16, 1, 'كندوان')," +
                "(17, 1, 'مراغه')," +
                "(18, 1, 'مرند')," +
                "(19, 1, 'ملكان')," +
                "(20, 1, 'ممقان')," +
                "(21, 1, 'ميانه')," +
                "(22, 1, 'هاديشهر')," +
                "(23, 1, 'هريس')," +
                "(24, 1, 'هشترود')," +
                "(25, 1, 'ورزقان')," +
                "(26, 2, 'اروميه')," +
                "(27, 2, 'اشنويه')," +
                "(28, 2, 'بازرگان')," +
                "(29, 2, 'بوكان')," +
                "(30, 2, 'پلدشت')," +
                "(31, 2, 'پيرانشهر')," +
                "(32, 2, 'تكاب')," +
                "(33, 2, 'خوي')," +
                "(34, 2, 'سردشت')," +
                "(35, 2, 'سلماس')," +
                "(36, 2, 'سيه چشمه- چالدران')," +
                "(37, 2, 'سیمینه')," +
                "(38, 2, 'شاهين دژ')," +
                "(39, 2, 'شوط')," +
                "(40, 2, 'ماكو')," +
                "(41, 2, 'مهاباد')," +
                "(42, 2, 'مياندوآب')," +
                "(43, 2, 'نقده')," +
                "(44, 3, 'اردبيل')," +
                "(45, 3, 'بيله سوار')," +
                "(46, 3, 'پارس آباد')," +
                "(47, 3, 'خلخال')," +
                "(48, 3, 'سرعين')," +
                "(49, 3, 'كيوي (كوثر)')," +
                "(50, 3, 'گرمي (مغان)')," +
                "(51, 3, 'مشگين شهر')," +
                "(52, 3, 'مغان (سمنان)')," +
                "(53, 3, 'نمين')," +
                "(54, 3, 'نير')," +
                "(55, 4, 'آران و بيدگل')," +
                "(56, 4, 'اردستان')," +
                "(57, 4, 'اصفهان')," +
                "(58, 4, 'باغ بهادران')," +
                "(59, 4, 'تيران')," +
                "(60, 4, 'خميني شهر')," +
                "(61, 4, 'خوانسار')," +
                "(62, 4, 'دهاقان')," +
                "(63, 4, 'دولت آباد-اصفهان')," +
                "(64, 4, 'زرين شهر')," +
                "(65, 4, 'زيباشهر (محمديه)')," +
                "(66, 4, 'سميرم')," +
                "(67, 4, 'شاهين شهر')," +
                "(68, 4, 'شهرضا')," +
                "(69, 4, 'فريدن')," +
                "(70, 4, 'فريدون شهر')," +
                "(71, 4, 'فلاورجان')," +
                "(72, 4, 'فولاد شهر')," +
                "(73, 4, 'قهدریجان')," +
                "(74, 4, 'كاشان')," +
                "(75, 4, 'گلپايگان')," +
                "(76, 4, 'گلدشت اصفهان')," +
                "(77, 4, 'گلدشت مركزی')," +
                "(78, 4, 'مباركه اصفهان')," +
                "(79, 4, 'مهاباد-اصفهان')," +
                "(80, 4, 'نايين')," +
                "(81, 4, 'نجف آباد')," +
                "(82, 4, 'نطنز')," +
                "(83, 4, 'هرند')," +
                "(84, 5, 'آسارا')," +
                "(85, 5, 'اشتهارد')," +
                "(86, 5, 'شهر جديد هشتگرد')," +
                "(87, 5, 'طالقان')," +
                "(88, 5, 'كرج')," +
                "(89, 5, 'گلستان تهران')," +
                "(90, 5, 'نظرآباد')," +
                "(91, 5, 'هشتگرد')," +
                "(92, 6, 'آبدانان')," +
                "(93, 6, 'ايلام')," +
                "(94, 6, 'ايوان')," +
                "(95, 6, 'دره شهر')," +
                "(96, 6, 'دهلران')," +
                "(97, 6, 'سرابله')," +
                "(98, 6, 'شيروان چرداول')," +
                "(99, 6, 'مهران')," +
                "(100, 7, 'آبپخش')," +
                "(101, 7, 'اهرم')," +
                "(102, 7, 'برازجان')," +
                "(103, 7, 'بندر دير')," +
                "(104, 7, 'بندر ديلم')," +
                "(105, 7, 'بندر كنگان')," +
                "(106, 7, 'بندر گناوه')," +
                "(107, 7, 'بوشهر')," +
                "(108, 7, 'تنگستان')," +
                "(109, 7, 'جزيره خارك')," +
                "(110, 7, 'جم (ولايت)')," +
                "(111, 7, 'خورموج')," +
                "(112, 7, 'دشتستان - شبانکاره')," +
                "(113, 7, 'دلوار')," +
                "(114, 7, 'عسلویه')," +
                "(115, 8, 'اسلامشهر')," +
                "(116, 8, 'بومهن')," +
                "(117, 8, 'پاكدشت')," +
                "(118, 8, 'تهران')," +
                "(119, 8, 'چهاردانگه')," +
                "(120, 8, 'دماوند')," +
                "(121, 8, 'رودهن')," +
                "(122, 8, 'ري')," +
                "(123, 8, 'شريف آباد')," +
                "(124, 8, 'شهر رباط كريم')," +
                "(125, 8, 'شهر شهريار')," +
                "(126, 8, 'فشم')," +
                "(127, 8, 'فيروزكوه')," +
                "(128, 8, 'قدس')," +
                "(129, 8, 'كهريزك')," +
                "(130, 8, 'لواسان بزرگ')," +
                "(131, 8, 'ملارد')," +
                "(132, 8, 'ورامين')," +
                "(133, 9, 'اردل')," +
                "(134, 9, 'بروجن')," +
                "(135, 9, 'چلگرد (كوهرنگ)')," +
                "(136, 9, 'سامان')," +
                "(137, 9, 'شهركرد')," +
                "(138, 9, 'فارسان')," +
                "(139, 9, 'لردگان')," +
                "(140, 10, 'بشرویه')," +
                "(141, 10, 'بيرجند')," +
                "(142, 10, 'خضری')," +
                "(143, 10, 'خوسف')," +
                "(144, 10, 'سرایان')," +
                "(145, 10, 'سربيشه')," +
                "(146, 10, 'طبس')," +
                "(147, 10, 'فردوس')," +
                "(148, 10, 'قائن')," +
                "(149, 10, 'نهبندان')," +
                "(150, 11, 'بجستان')," +
                "(151, 11, 'بردسكن')," +
                "(152, 11, 'تايباد')," +
                "(153, 11, 'تربت جام')," +
                "(154, 11, 'تربت حيدريه')," +
                "(155, 11, 'جغتای')," +
                "(156, 11, 'جوین')," +
                "(157, 11, 'چناران')," +
                "(158, 11, 'خلیل آباد')," +
                "(159, 11, 'خواف')," +
                "(160, 11, 'درگز')," +
                "(161, 11, 'رشتخوار')," +
                "(162, 11, 'سبزوار')," +
                "(163, 11, 'سرخس')," +
                "(164, 11, 'طبس')," +
                "(165, 11, 'طرقبه')," +
                "(166, 11, 'فريمان')," +
                "(167, 11, 'قوچان')," +
                "(168, 11, 'كاشمر')," +
                "(169, 11, 'كلات')," +
                "(170, 11, 'گناباد')," +
                "(171, 11, 'مشهد')," +
                "(172, 11, 'نيشابور')," +
                "(173, 12, 'آشخانه، مانه و سمرقان')," +
                "(174, 12, 'اسفراين')," +
                "(175, 12, 'بجنورد')," +
                "(176, 12, 'جاجرم')," +
                "(177, 12, 'شيروان')," +
                "(178, 12, 'فاروج')," +
                "(179, 13, 'آبادان')," +
                "(180, 13, 'اميديه')," +
                "(181, 13, 'انديمشك')," +
                "(182, 13, 'اهواز')," +
                "(183, 13, 'ايذه')," +
                "(184, 13, 'باغ ملك')," +
                "(185, 13, 'بستان')," +
                "(186, 13, 'بندر ماهشهر')," +
                "(187, 13, 'بندرامام خميني')," +
                "(188, 13, 'بهبهان')," +
                "(189, 13, 'خرمشهر')," +
                "(190, 13, 'دزفول')," +
                "(191, 13, 'رامشیر')," +
                "(192, 13, 'رامهرمز')," +
                "(193, 13, 'سوسنگرد')," +
                "(194, 13, 'شادگان')," +
                "(195, 13, 'شوش')," +
                "(196, 13, 'شوشتر')," +
                "(197, 13, 'لالي')," +
                "(198, 13, 'مسجد سليمان')," +
                "(199, 13, 'هنديجان')," +
                "(200, 13, 'هويزه')," +
                "(201, 14, 'آب بر (طارم)')," +
                "(202, 14, 'ابهر')," +
                "(203, 14, 'خرمدره')," +
                "(204, 14, 'زرین آباد (ایجرود)')," +
                "(205, 14, 'زنجان')," +
                "(206, 14, 'قیدار (خدا بنده)')," +
                "(207, 14, 'ماهنشان')," +
                "(208, 15, 'ايوانكي')," +
                "(209, 15, 'بسطام')," +
                "(210, 15, 'دامغان')," +
                "(211, 15, 'سرخه')," +
                "(212, 15, 'سمنان')," +
                "(213, 15, 'شاهرود')," +
                "(214, 15, 'شهمیرزاد')," +
                "(215, 15, 'گرمسار')," +
                "(216, 15, 'مهدیشهر')," +
                "(217, 16, 'ايرانشهر')," +
                "(218, 16, 'چابهار')," +
                "(219, 16, 'خاش')," +
                "(220, 16, 'راسك')," +
                "(221, 16, 'زابل')," +
                "(222, 16, 'زاهدان')," +
                "(223, 16, 'سراوان')," +
                "(224, 16, 'سرباز')," +
                "(225, 16, 'ميرجاوه')," +
                "(226, 16, 'نيكشهر')," +
                "(227, 17, 'آباده')," +
                "(228, 17, 'آباده طشك')," +
                "(229, 17, 'اردكان')," +
                "(230, 17, 'ارسنجان')," +
                "(231, 17, 'استهبان')," +
                "(232, 17, 'اشكنان')," +
                "(233, 17, 'اقليد')," +
                "(234, 17, 'اوز')," +
                "(235, 17, 'ایج')," +
                "(236, 17, 'ایزد خواست')," +
                "(237, 17, 'باب انار')," +
                "(238, 17, 'بالاده')," +
                "(239, 17, 'بنارويه')," +
                "(240, 17, 'بهمن')," +
                "(241, 17, 'بوانات')," +
                "(242, 17, 'بيرم')," +
                "(243, 17, 'بیضا')," +
                "(244, 17, 'جنت شهر')," +
                "(245, 17, 'جهرم')," +
                "(246, 17, 'حاجي آباد-زرین دشت')," +
                "(247, 17, 'خاوران')," +
                "(248, 17, 'خرامه')," +
                "(249, 17, 'خشت')," +
                "(250, 17, 'خفر')," +
                "(251, 17, 'خنج')," +
                "(252, 17, 'خور')," +
                "(253, 17, 'داراب')," +
                "(254, 17, 'رونيز عليا')," +
                "(255, 17, 'زاهدشهر')," +
                "(256, 17, 'زرقان')," +
                "(257, 17, 'سده')," +
                "(258, 17, 'سروستان')," +
                "(259, 17, 'سعادت شهر')," +
                "(260, 17, 'سورمق')," +
                "(261, 17, 'ششده')," +
                "(262, 17, 'شيراز')," +
                "(263, 17, 'صغاد')," +
                "(264, 17, 'صفاشهر')," +
                "(265, 17, 'علاء مرودشت')," +
                "(266, 17, 'عنبر')," +
                "(267, 17, 'فراشبند')," +
                "(268, 17, 'فسا')," +
                "(269, 17, 'فيروز آباد')," +
                "(270, 17, 'قائميه')," +
                "(271, 17, 'قادر آباد')," +
                "(272, 17, 'قطب آباد')," +
                "(273, 17, 'قير')," +
                "(274, 17, 'كازرون')," +
                "(275, 17, 'كنار تخته')," +
                "(276, 17, 'گراش')," +
                "(277, 17, 'لار')," +
                "(278, 17, 'لامرد')," +
                "(279, 17, 'لپوئی')," +
                "(280, 17, 'لطيفي')," +
                "(281, 17, 'مبارك آباد ديز')," +
                "(282, 17, 'مرودشت')," +
                "(283, 17, 'مشكان')," +
                "(284, 17, 'مصير')," +
                "(285, 17, 'مهر فارس(گله دار)')," +
                "(286, 17, 'ميمند')," +
                "(287, 17, 'نوبندگان')," +
                "(288, 17, 'نودان')," +
                "(289, 17, 'نورآباد')," +
                "(290, 17, 'ني ريز')," +
                "(291, 17, 'کوار')," +
                "(292, 18, 'آبيك')," +
                "(293, 18, 'البرز')," +
                "(294, 18, 'بوئين زهرا')," +
                "(295, 18, 'تاكستان')," +
                "(296, 18, 'قزوين')," +
                "(297, 18, 'محمود آباد نمونه')," +
                "(298, 19, 'قم')," +
                "(299, 20, 'بانه')," +
                "(300, 20, 'بيجار')," +
                "(301, 20, 'دهگلان')," +
                "(302, 20, 'ديواندره')," +
                "(303, 20, 'سقز')," +
                "(304, 20, 'سنندج')," +
                "(305, 20, 'قروه')," +
                "(306, 20, 'كامياران')," +
                "(307, 20, 'مريوان')," +
                "(308, 21, 'بابك')," +
                "(309, 21, 'بافت')," +
                "(310, 21, 'بردسير')," +
                "(311, 21, 'بم')," +
                "(312, 21, 'جيرفت')," +
                "(313, 21, 'راور')," +
                "(314, 21, 'رفسنجان')," +
                "(315, 21, 'زرند')," +
                "(316, 21, 'سيرجان')," +
                "(317, 21, 'كرمان')," +
                "(318, 21, 'كهنوج')," +
                "(319, 21, 'منوجان')," +
                "(320, 22, 'اسلام آباد غرب')," +
                "(321, 22, 'پاوه')," +
                "(322, 22, 'تازه آباد- ثلاث باباجانی')," +
                "(323, 22, 'جوانرود')," +
                "(324, 22, 'سر پل ذهاب')," +
                "(325, 22, 'سنقر كليائي')," +
                "(326, 22, 'صحنه')," +
                "(327, 22, 'قصر شيرين')," +
                "(328, 22, 'كرمانشاه')," +
                "(329, 22, 'كنگاور')," +
                "(330, 22, 'گيلان غرب')," +
                "(331, 22, 'هرسين')," +
                "(332, 23, 'دهدشت')," +
                "(333, 23, 'دوگنبدان')," +
                "(334, 23, 'سي سخت- دنا')," +
                "(335, 23, 'گچساران')," +
                "(336, 23, 'ياسوج')," +
                "(337, 24, 'آزاد شهر')," +
                "(338, 24, 'آق قلا')," +
                "(339, 24, 'انبارآلوم')," +
                "(340, 24, 'اینچه برون')," +
                "(341, 24, 'بندر گز')," +
                "(342, 24, 'بندرتركمن')," +
                "(343, 24, 'جلین')," +
                "(344, 24, 'خان ببین')," +
                "(345, 24, 'راميان')," +
                "(346, 24, 'سرخس کلاته')," +
                "(347, 24, 'سیمین شهر')," +
                "(348, 24, 'علي آباد كتول')," +
                "(349, 24, 'فاضل آباد')," +
                "(350, 24, 'كردكوي')," +
                "(351, 24, 'كلاله')," +
                "(352, 24, 'گالیکش')," +
                "(353, 24, 'گرگان')," +
                "(354, 24, 'گمیش تپه')," +
                "(355, 24, 'گنبد كاووس')," +
                "(356, 24, 'مراوه تپه')," +
                "(357, 24, 'مينو دشت')," +
                "(358, 24, 'نگین شهر')," +
                "(359, 24, 'نوده خاندوز')," +
                "(360, 24, 'نوکنده')," +
                "(361, 25, 'آستارا')," +
                "(362, 25, 'آستانه اشرفيه')," +
                "(363, 25, 'املش')," +
                "(364, 25, 'بندرانزلي')," +
                "(365, 25, 'خمام')," +
                "(366, 25, 'رشت')," +
                "(367, 25, 'رضوان شهر')," +
                "(368, 25, 'رود سر')," +
                "(369, 25, 'رودبار')," +
                "(370, 25, 'سياهكل')," +
                "(371, 25, 'شفت')," +
                "(372, 25, 'صومعه سرا')," +
                "(373, 25, 'فومن')," +
                "(374, 25, 'كلاچاي')," +
                "(375, 25, 'لاهيجان')," +
                "(376, 25, 'لنگرود')," +
                "(377, 25, 'لوشان')," +
                "(378, 25, 'ماسال')," +
                "(379, 25, 'ماسوله')," +
                "(380, 25, 'منجيل')," +
                "(381, 25, 'هشتپر')," +
                "(382, 26, 'ازنا')," +
                "(383, 26, 'الشتر')," +
                "(384, 26, 'اليگودرز')," +
                "(385, 26, 'بروجرد')," +
                "(386, 26, 'پلدختر')," +
                "(387, 26, 'خرم آباد')," +
                "(388, 26, 'دورود')," +
                "(389, 26, 'سپید دشت')," +
                "(390, 26, 'كوهدشت')," +
                "(391, 26, 'نورآباد (خوزستان)')," +
                "(392, 27, 'آمل')," +
                "(393, 27, 'بابل')," +
                "(394, 27, 'بابلسر')," +
                "(395, 27, 'بلده')," +
                "(396, 27, 'بهشهر')," +
                "(397, 27, 'پل سفيد')," +
                "(398, 27, 'تنكابن')," +
                "(399, 27, 'جويبار')," +
                "(400, 27, 'چالوس')," +
                "(401, 27, 'خرم آباد')," +
                "(402, 27, 'رامسر')," +
                "(403, 27, 'رستم کلا')," +
                "(404, 27, 'ساري')," +
                "(405, 27, 'سلمانشهر')," +
                "(406, 27, 'سواد كوه')," +
                "(407, 27, 'فريدون كنار')," +
                "(408, 27, 'قائم شهر')," +
                "(409, 27, 'گلوگاه')," +
                "(410, 27, 'محمودآباد')," +
                "(411, 27, 'مرزن آباد')," +
                "(412, 27, 'نكا')," +
                "(413, 27, 'نور')," +
                "(414, 27, 'نوشهر')," +
                "(415, 28, 'آشتيان')," +
                "(416, 28, 'اراك')," +
                "(417, 28, 'تفرش')," +
                "(418, 28, 'خمين')," +
                "(419, 28, 'دليجان')," +
                "(420, 28, 'ساوه')," +
                "(421, 28, 'شازند')," +
                "(422, 28, 'محلات')," +
                "(423, 28, 'کمیجان')," +
                "(424, 29, 'ابوموسي')," +
                "(425, 29, 'انگهران')," +
                "(426, 29, 'بستك')," +
                "(427, 29, 'بندر جاسك')," +
                "(428, 29, 'بندر لنگه')," +
                "(429, 29, 'بندرعباس')," +
                "(430, 29, 'پارسیان')," +
                "(431, 29, 'حاجي آباد')," +
                "(432, 29, 'دشتی')," +
                "(433, 29, 'دهبارز (رودان)')," +
                "(434, 29, 'قشم')," +
                "(435, 29, 'كيش')," +
                "(436, 29, 'ميناب')," +
                "(437, 30, 'اسدآباد')," +
                "(438, 30, 'بهار')," +
                "(439, 30, 'تويسركان')," +
                "(440, 30, 'رزن')," +
                "(441, 30, 'كبودر اهنگ')," +
                "(442, 30, 'ملاير')," +
                "(443, 30, 'نهاوند')," +
                "(444, 30, 'همدان')," +
                "(445, 31, 'ابركوه')," +
                "(446, 31, 'اردكان')," +
                "(447, 31, 'اشكذر')," +
                "(448, 31, 'بافق')," +
                "(449, 31, 'تفت')," +
                "(450, 31, 'مهريز')," +
                "(451, 31, 'ميبد')," +
                "(452, 31, 'هرات')," +
                "(453, 31, 'يزد');";

        db.execSQL(CREATE_TABLE);

        CREATE_TABLE = "CREATE TABLE IF NOT EXISTS  province("
                + "[ID] [int] NOT NULL," + "[name] [ntext] NULL )"
        ;

        db.execSQL(CREATE_TABLE);


        CREATE_TABLE = "INSERT INTO 'province' ('id', 'name') VALUES" +
                "(1, 'آذربايجان شرقي')," +
                "(2, 'آذربايجان غربي')," +
                "(3, 'اردبيل')," +
                "(4, 'اصفهان')," +
                "(5, 'البرز')," +
                "(6, 'ايلام')," +
                "(7, 'بوشهر')," +
                "(8, 'تهران')," +
                "(9, 'چهارمحال بختياري')," +
                "(10, 'خراسان جنوبي')," +
                "(11, 'خراسان رضوي')," +
                "(12, 'خراسان شمالي')," +
                "(13, 'خوزستان')," +
                "(14, 'زنجان')," +
                "(15, 'سمنان')," +
                "(16, 'سيستان و بلوچستان')," +
                "(17, 'فارس')," +
                "(18, 'قزوين')," +
                "(19, 'قم')," +
                "(20, 'كردستان')," +
                "(21, 'كرمان')," +
                "(22, 'كرمانشاه')," +
                "(23, 'كهكيلويه و بويراحمد')," +
                "(24, 'گلستان')," +
                "(25, 'گيلان')," +
                "(26, 'لرستان')," +
                "(27, 'مازندران')," +
                "(28, 'مركزي')," +
                "(29, 'هرمزگان')," +
                "(30, 'همدان')," +
                "(31, 'يزد');";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
        onCreate(db);
    }
}