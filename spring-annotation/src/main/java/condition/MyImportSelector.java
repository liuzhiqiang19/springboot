package condition;

import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector
{
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata)
    {
        String[] strings = new String[]{"bean.Color", "bean.Red"};
        return strings;
    }
}
