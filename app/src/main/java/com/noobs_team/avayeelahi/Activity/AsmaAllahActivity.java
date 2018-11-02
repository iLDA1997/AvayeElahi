package com.noobs_team.avayeelahi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.noobs_team.avayeelahi.Adapter.AsmaAllahAdapter;
import com.noobs_team.avayeelahi.Data.AsmaAllahList;
import com.noobs_team.avayeelahi.R;

import java.util.ArrayList;
import java.util.List;

public class AsmaAllahActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarAsmaAllah;
    ListView asmaAllahListView;

    List<AsmaAllahList> asmaAllah;
    AsmaAllahAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asma_allah);
        toolbarAsmaAllah = findViewById(R.id.toolbar_asma_allah);
        toolbarAsmaAllah.setTitle(R.string.app_activity_asma_allah);
        setSupportActionBar(toolbarAsmaAllah);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarAsmaAllah.setTitleTextColor(getResources().getColor(R.color.textTitleColor));
        asmaAllahListView = (ListView) findViewById(R.id.asma_allah_list);
        asmaAllah = new ArrayList<>();
        prepareData();
        refreshDisplay();
    }

    private void prepareData() {
        asmaAllah.add(new AsmaAllahList("اَلرَّحْمنُ", "1. Ar-Rahman", "بخشاینده"));
        asmaAllah.add(new AsmaAllahList("اَلرَّحِيْمُ", "2. Ar-Rahim", "مهربان"));
        asmaAllah.add(new AsmaAllahList("اَلْمَلِکُ", "3. Al-Malik", "پادشاه"));
        asmaAllah.add(new AsmaAllahList("اَلْقُدُّوسُ", "4. Al-Quddus", "مقدس"));
        asmaAllah.add(new AsmaAllahList("اَلسَّلاَمُ", "5. As-Salam", "پاک و سلامتی بخش عالم"));
        asmaAllah.add(new AsmaAllahList("اَلْمُؤْمِنُ", "6. Al-Mumin", "اطمینان دهنده"));
        asmaAllah.add(new AsmaAllahList("اَلْمُهَيْمِنُ", "7. Al -Muhaymin", "نگهدارنده"));
        asmaAllah.add(new AsmaAllahList("اَلْعَزِيْزُ", "8. Al-Aziz", "باشکوه"));
        asmaAllah.add(new AsmaAllahList("اَلْجَبَّارُ", "9. Al-Jabbar", "توانگر"));
        asmaAllah.add(new AsmaAllahList("اَلْمُتَکَبِّرُ", "10. Al-Mutakabbir", "بسیاربزرگ"));

        asmaAllah.add(new AsmaAllahList("اَلْخَالِقُ", "11. Al-Khaliq", "آفریننده"));
        asmaAllah.add(new AsmaAllahList("اَلْبَارِيءُ", "12. Al-Bari", "درست"));
        asmaAllah.add(new AsmaAllahList("اَلْمُصَوِّرُ", "13. Al-Musawwir", "نگارگر، صورتگر"));
        asmaAllah.add(new AsmaAllahList("اَلغَفَّارُ", "14. Al-Ghaffar", "همیشه بخشاینده"));
        asmaAllah.add(new AsmaAllahList("اَلْقَهَّارُ", "15. Al-Qahhar", "فروکاهنده"));
        asmaAllah.add(new AsmaAllahList("اَلْوَهَّابُ", "16. Al-Wahhab", "نیک بخشاینده"));
        asmaAllah.add(new AsmaAllahList("اَلرَّزَّاقُ", "17. Ar-Razzaq", "همیشه روزی دهنده"));
        asmaAllah.add(new AsmaAllahList("اَلْفَتَّاحُ", "18. Al-Fattah", "گشاینده (پیروز کننده)"));
        asmaAllah.add(new AsmaAllahList("اَلْعَلِيْمُ", "19. Al-Alim", "داناترین"));
        asmaAllah.add(new AsmaAllahList("اَلْقَابِضُ", "20. Al-Qabid", "میراننده، بیرون کشنده جان ها"));

        asmaAllah.add(new AsmaAllahList("اَلْبَاسِطُ", "21. Al-Basit", "گستراننده ، فراخ کننده روزی"));
        asmaAllah.add(new AsmaAllahList("اَلْخَافِضُ", "22. Al-Khafid", "پست کننده ، خارکننده"));
        asmaAllah.add(new AsmaAllahList("اَلرَّافِعُ", "23. Ar-Rafi", "(به سوی خود) بالا برنده"));
        asmaAllah.add(new AsmaAllahList("اَلْمُعِزُّ", "24. Al-Muizz", "عزیز کننده"));
        asmaAllah.add(new AsmaAllahList("اَلْمُذِلُّ", "25. Al-Mudhill", "خار کننده"));
        asmaAllah.add(new AsmaAllahList("اَلسَّمِيْعُ", "26. As-Sami", "شنواترین"));
        asmaAllah.add(new AsmaAllahList("اَلْبَصِيْرُ", "27. Al-Basir", "بیناترین"));
        asmaAllah.add(new AsmaAllahList("اَلْحَکَمُ", "28. Al-Hakam", "دادگر"));
        asmaAllah.add(new AsmaAllahList("اَلْعَدْلُ", "29. Al-Adl", "بی نهایت عادل"));
        asmaAllah.add(new AsmaAllahList("اَللَّطِيْفُ", "30. Al-Latif", "آنکه بر بندگانش لطف دارد"));

        asmaAllah.add(new AsmaAllahList("اَلْخَبِيْرُ", "31.  Al-Khabir", "آگاه ترین"));
        asmaAllah.add(new AsmaAllahList("اَلْحَلِيْمُ", "32. Al-Halim", "بسیار بردبار"));
        asmaAllah.add(new AsmaAllahList("اَلْعَظِيْمُ", "33. Al-Azim", "بی انتها"));
        asmaAllah.add(new AsmaAllahList("اَلْغَفُوْرُ", "34. Al-Ghafur", "بسیار بخشاینده"));
        asmaAllah.add(new AsmaAllahList("اَلشَّکُوْرُ", "35. Ash-Shakur", "بسیار سپاس گزا"));
        asmaAllah.add(new AsmaAllahList("اَلْعَلِي", "36. Al-Ali", "بلند مرتبه"));
        asmaAllah.add(new AsmaAllahList("اَلْکَبِيْرُ", "37. Al-Kabir", "بزرگ ترین"));
        asmaAllah.add(new AsmaAllahList("اَلْحَفِيْظُ", "38. Al-Hafiz", "نگهدارنده"));
        asmaAllah.add(new AsmaAllahList("اَلْمُقِيْتُ", "39. Al-Muqit", "خوراک دهنده"));
        asmaAllah.add(new AsmaAllahList("اَلْحَسِيْبُ", "40. Al-Hasib", "شمارنده"));

        asmaAllah.add(new AsmaAllahList("اَلْجَلِيْلُ", "41. Al-Jalil", "بسیار گرانقدر"));
        asmaAllah.add(new AsmaAllahList("اَلْکَرِيْمُ", "42. Al-Karim", "بسیار بخشنده"));
        asmaAllah.add(new AsmaAllahList("اَلرَّقِيْبُ", "43. Ar-Raqib", "نگهبان، بیننده وآماده"));
        asmaAllah.add(new AsmaAllahList("اَلْمُجِيْبُ", "44. Al-Mujib", "پاسخگو"));
        asmaAllah.add(new AsmaAllahList("اَلْوَاسِعُ", "45. Al-Wasi", "گسترده ، پهناور"));
        asmaAllah.add(new AsmaAllahList("اَلْحَکِيْمُ", "46. Al-Hakim", "فرزانه ، بسیارخردمند"));
        asmaAllah.add(new AsmaAllahList("اَلوَدُوْدُ", "47. Al-Wadud", "دوست"));
        asmaAllah.add(new AsmaAllahList("اَلْمَجِيْدُ", "48. Al-Majíd", "بسیار لایق ستایش"));
        asmaAllah.add(new AsmaAllahList("اَلْبَاعِثُ", "49. Al-Baith", "برانگیزنده مردگان"));
        asmaAllah.add(new AsmaAllahList("اَلشَّهِيْدُ", "50. Ash-Shahid", "بیننده"));

        asmaAllah.add(new AsmaAllahList("اَلْحَقُّ", "51. Al-Haqq", "راست ، درست"));
        asmaAllah.add(new AsmaAllahList("اَلْوَکِيْلُ", "52. Al-Wakil", "عهده دار همه امور بندگان و موجودات"));
        asmaAllah.add(new AsmaAllahList("اَلْقَوِي", "53. Al-Qawi", "پرزور"));
        asmaAllah.add(new AsmaAllahList("اَلْمَتِيْنُ", "54. Al-Matin", "سخت (و نیز پاینده)"));
        asmaAllah.add(new AsmaAllahList("اَلْوَلِي", "55. Al-Wali", "دوست ، یار ونگهبان"));
        asmaAllah.add(new AsmaAllahList("اَلْحَمِيْدُ", "56. Al-Hamid", "ستوده"));
        asmaAllah.add(new AsmaAllahList("اَلْمُحْصِي", "57. Al-Muhsi", "شمارنده"));
        asmaAllah.add(new AsmaAllahList("اَلْمُبْدِيءُ", "58. Al-Mubdi", "نخستین آفریننده"));
        asmaAllah.add(new AsmaAllahList("اَلْمُعِيْدُ", "59. Al-Muid", "بازگرداننده ، دوباره زنده کننده"));
        asmaAllah.add(new AsmaAllahList("اَلْمُحيي", "60. Al-Muhyi", "زندگی بخش ، هستی بخش"));

        asmaAllah.add(new AsmaAllahList("اَلْمُمِيْتُ", "61. Al-Mumit", "میراننده ، نابودکننده"));
        asmaAllah.add(new AsmaAllahList("اَلْحَي", "62. Al-Hayy", "زنده"));
        asmaAllah.add(new AsmaAllahList("اَلْقَيُّوْمُ", "63. Al-Qayyum", "قائم به ذات(همه-آفریننده ای که کسی اورا نیافرید) ، پاینده"));
        asmaAllah.add(new AsmaAllahList("اَلْوَاجِدُ", "64. Al-Wajid", "یابنده"));
        asmaAllah.add(new AsmaAllahList("اَلْمَاجِدُ", "65. Al-Majid", "بزرگوار"));
        asmaAllah.add(new AsmaAllahList("اَلْوَاحِدُ", "66. Al-Wahid", "یکتای بی همتا"));
        asmaAllah.add(new AsmaAllahList("الاحد", "67. Al-Ahad", "یگانه(خدایی جز او نیست)"));
        asmaAllah.add(new AsmaAllahList("اَلصَّمَدُ", "68. As-Samad", "بی نیاز"));
        asmaAllah.add(new AsmaAllahList("اَلْقَادِرُ", "69. Al-Qadir", "توانا"));
        asmaAllah.add(new AsmaAllahList("اَلْمُقْتَدِرُ", "70. Al-Muqtadir", "تعیین کننده(قضا وقدر)"));
        asmaAllah.add(new AsmaAllahList("اَلْمُقَدِّمُ", "71. Al-Muqaddim", "فراپیش کشنده"));

        asmaAllah.add(new AsmaAllahList("اَلْمُؤَخِّرُ", "72. Al-Muakhkhir", "پس گذارنده چیزها و نهنده آن ها به جای آن ها"));
        asmaAllah.add(new AsmaAllahList("اَلأَوَّلُ", "73. Al-Awwal", "نخستین ، اول پدیدارکننده وجود"));
        asmaAllah.add(new AsmaAllahList("اَلآخِرُ", "74. Al-Akhir", "واپسین ، آخر فناکننده موجود"));
        asmaAllah.add(new AsmaAllahList("اَلظَّاهِرُ", "75. Az-Zahir", "آشکار"));
        asmaAllah.add(new AsmaAllahList("اَلْبَاطِنُ", "76. Al-Batin", "پنهان"));
        asmaAllah.add(new AsmaAllahList("اَلْوَالِي", "77. Al-Walí", "یگانه سرپرستی که همه ولایت ها ازاوست"));
        asmaAllah.add(new AsmaAllahList("اَلْمُتَعَالِي", "78. Al-Mutaali", "خودستوده"));
        asmaAllah.add(new AsmaAllahList("اَلْبِرُّ", "79. Al-Barr", "نیکوترین"));
        asmaAllah.add(new AsmaAllahList("اَلتَّوَّابُ", "80. Al-Tawwab", "همیشه توبه پذیر"));
        asmaAllah.add(new AsmaAllahList("اَلْمُنْتَقِمُ", "81. Al-Muntaqim", "انتقام گیر"));

        asmaAllah.add(new AsmaAllahList("اَلْعَفُوُّ", "82. Al-Afu", "آمرزنده"));
        asmaAllah.add(new AsmaAllahList("اَلرَّؤُوفُ", "83. Ar-Rauf", "بسیار دلسوز و مهربان"));
        asmaAllah.add(new AsmaAllahList("مَالِکَ الْمُلْکِ", "84. Malik al-Mulk", "فرمانروای جهان"));
        asmaAllah.add(new AsmaAllahList("ذُوالْجَلاَلِ وَالإِکْرَامِ", "85. Dhul-Jalali Wal-Ikram", "دارای شکوه و بخشش"));
        asmaAllah.add(new AsmaAllahList("اَلْمُقْسِطُ:", "86. Al-Muqsit", "عادل"));
        asmaAllah.add(new AsmaAllahList("اَلْجَامِعُ", "87. Al-Jami", "گردآورنده"));
        asmaAllah.add(new AsmaAllahList("اَلْغَنِي", "88. Al-Ghani", "توانگر"));
        asmaAllah.add(new AsmaAllahList("اَلْمُغْنِي", "89. Al-Mughni", "بی نیاز کننده"));
        asmaAllah.add(new AsmaAllahList("اَلْمَانِعُ", "90. Al-Mani", "بازدارنده"));
        asmaAllah.add(new AsmaAllahList("اَلضَّارُ", "91. Ad-Darr", "آزار دهنده(این صفت تنها دراحادیث یافت می شود)"));

        asmaAllah.add(new AsmaAllahList("اَلنَّافِعُ", "92. An-Nafi", "سودمند"));
        asmaAllah.add(new AsmaAllahList("اَلنُّوْرُ", "93. An-Nur", "روشنی"));
        asmaAllah.add(new AsmaAllahList("اَلْهَادِي", "94. Al-Hadi", "رهنما"));
        asmaAllah.add(new AsmaAllahList("اَلْبَدِيْعُ", "95. Al-Badi", "سنجش ناپذیر ، آفریننده"));
        asmaAllah.add(new AsmaAllahList("اَلْبَاقِي", "96. Al-Baqi", "ماندگار و واگردان نشدنی(تغییر ناپذیر)"));
        asmaAllah.add(new AsmaAllahList("اَلْوَارِثُ", "97. Al-Warith", "مالک نهایی تمام مخلوقات"));
        asmaAllah.add(new AsmaAllahList("اَلرَّشِيْدُ", "98. Ar-Rashid", "راهنما ، آموزگار ودانای بی خطا"));
        asmaAllah.add(new AsmaAllahList("اَلصَّبُورُ", "99. As-Sabur", "شکیبا"));
    }

    private void refreshDisplay() {
        adapter = new AsmaAllahAdapter(this,R.layout.item_asma_allah, asmaAllah);
        asmaAllahListView.setAdapter(adapter);
    }
}
