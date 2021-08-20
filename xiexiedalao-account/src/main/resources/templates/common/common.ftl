<#ftl encoding="UTF-8" strip_whitespace=true output_format="HTML">
<#--ftl配置-->
<#macro page cssList jsList >
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <#if cssList??>
            <#list cssList as cssPath>
                <link rel="stylesheet" href="${cssPath!}"></link>
            </#list>
        </#if>
        <title>Document</title>
    </head>
    <body>
        <#nested >
    <script>
    </script>
    <script src="${base!}/js/jquery/jquery.min.js" type="text/javascript"></script>
    <#if jsList??>
        <#--遍历所有的js数据-->
        <#list jsList as jsPath>
            <script src="${jsPath!}" type="text/javascript"></script>
        </#list>
    </#if>
    </body>
    </html>
</#macro>
