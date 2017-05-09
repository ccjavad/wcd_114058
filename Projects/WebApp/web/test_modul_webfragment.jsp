<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        Contextparameter 'Kursname' aus einem Webfragment: 
        ${initParam.Kursname}
        
        <hr/>
        Webfragment vorbereitet im Unterverzeichnis '_build_jar' im 
        Projekt 'WebAppModul_Webfragment'
        <hr/>
        
        
        <h1>Die Tags 'web-app' aus DD und 'web-fragment' aus dem Webfragment</h1>
        
        <h2>Attribut 'metadata-complete'</h2>
        
        metadata-complete=true in dem Webfragment heißt: 
        Annotationen in der Jar-Datei des Webfragments werden ignoriert. <br/>
        
        metadata-complete=true in dem DD heißt: 
        alle Annotationen werden ignoriert. 
        
        
        <h2>Reihenfolge der Webfragmente für web-app (DD):</h2>
        
        <%--
            Exam:
        
            Es gibt drei Webfragmente: A, B, C
            Mit welcher Antwort bekommt man die Reihenfolge A B C beim Deployen?
        

Richtig:
            <absolute-ordering>
                <name>A</name>
                <name>B</name>
                <name>C</name>
            </absolute-ordering>
oder        
            <absolute-ordering>
                <others/>
                <name>B</name>
                <name>C</name>
            </absolute-ordering>
oder        
            <absolute-ordering>
                <name>A</name>
                <others/>
                <name>C</name>
            </absolute-ordering>
oder        
            <absolute-ordering>
                <name>A</name>
                <name>B</name>
                <others/>
            </absolute-ordering>
        
        --%>
        
        
        <h2>Reihenfolge der Webfragmente in web-fragment (Webfragment):</h2>
        
        <%--
            Ein Webfragment B kann seine relative Position (relativ zu den anderen Webfragmenten) 
            selbst bestimmen. So bekommt man die Reihenfolge A B C:
        
            <web-fragment>
                <name>B</name>

                <ordering>
                    <after>A</after>
                    <before>C</before>
                </ordering>
            </web-fragment>
        --%>
        
    </body>
</html>
