package rongda;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.util.HashMap;
import java.util.Map;

public class CreatePdf {

    public static void main(String[] args) throws Exception {
        //模板文件路径
        String filePath = "C:\\Users\\74582\\Desktop\\haha.pdf";
        //标准化输出文件路径
        String toPath = "C:\\Users\\74582\\Desktop\\haha_output.pdf";
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(filePath), new PdfWriter(toPath));
        PdfAcroForm pdfAcroForm = PdfAcroForm.getAcroForm(pdfDoc, true);
        //原始数据(待填充到PDF文件中的数据)
        Map<String, String> formDatas = new HashMap<>();
        formDatas.put("fill_1","总理斯蒂芬拉萨大家ask地方啦爱丽丝打开房间阿里山的开发啊拉萨看得见伐啦");
        formDatas.put("fill_2","2023");
        formDatas.put("fill_3","    1");
        formDatas.put("fill_4","   8");
        formDatas.put("fill_5","5");
        formDatas.put("fill_6","6");
        formDatas.put("fill_7","7");
        formDatas.put("fill_8","8");
        //获取模板文件中的全量字段
        Map<String, PdfFormField> formFields = pdfAcroForm.getFormFields();
        formFields.forEach((key, value) -> {
            try {
                //处理中文乱码
                PdfFont font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
                //获取到模板中的某个字段
                PdfFormField agreementId = formFields.get(key);
                agreementId.setFont(font);
                //为模板中的某个字段设置值
                agreementId.setValue(formDatas.get(key));
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        //设置生成表单不可编辑，注意itext的版本，在7.0.0版本报错
        pdfAcroForm.flattenFields();
        pdfDoc.close();
    }
}
