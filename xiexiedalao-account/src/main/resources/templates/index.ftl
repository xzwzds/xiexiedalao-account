<@c.page
cssList = ["${base!}/css/index.css"]
jsList = ["${base!}/js/index.js"]>
    <div class="box">
        <#if userName??>
            ${userName!}
        </#if>
    </div>
</@c.page>