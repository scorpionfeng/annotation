package com.xtooltech.process;


import com.xtooltech.ann.LogTag;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;


@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("com.xtooltech.ann.LogTag")

public class LogProcessor extends AbstractProcessor {
    private Filer mFiler;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFiler = processingEnv.getFiler();
    }


    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        make();
        return true;
    }

    public void make() {

        String packageName = "com.ken";
        String newClassName = "Kenx";
        String retStr = "";

        StringBuilder builder = new StringBuilder()
                .append("package " + packageName + ";\n\n")
                .append("public class ")
                .append(newClassName)
                .append(" {\n\n")
                .append("\tpublic String getMessage() {\n")
                .append("\t\treturn \"");

        // this is appending to the return statement
        builder.append(retStr).append(" !\\n");

        builder.append("\";\n")
                .append("\t}\n")
                .append("}\n");

        try { // write the file
            JavaFileObject source = mFiler.createSourceFile(packageName + "." + newClassName);
            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
        }
    }



    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> anns=new LinkedHashSet<>();
        anns.add(LogTag.class.getCanonicalName());
        return anns;
    }


    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

}
