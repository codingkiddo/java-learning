package com.example.generics;

import java.util.ArrayList;
import java.util.List;

abstract class Fruit {
	abstract String getFruitName();
}

class Banana extends Fruit {
	@Override
	String getFruitName() {
		return "Banana Fruit";
	}
}

class Orange extends Fruit {
	@Override
	String getFruitName() {
		return "Orange Fruit";
	}
}

abstract class Book {
	abstract String getBookName();
}

class TextBook extends Book {
	@Override
	String getBookName() {
		return "Text Book";
	}
}

class NoteBook extends Book {
	@Override
	String getBookName() {
		return "Note Book";
	}
}

public class SampleFruits {

	public static void main(String[] args) {

		List<Banana> fruitsBasket1 = new ArrayList<Banana>();
		fruitsBasket1.add(new Banana());
//		
		Book book = new NoteBook();

		List<Fruit> fruitsBasket2 = new ArrayList<Fruit>();
//		copy(fruitsBasket1, fruitsBasket2);
//		System.out.println(fruitsBasket2);

		List<Book> booksBasket1 = new ArrayList<Book>();
//		List<Book> booksBasket2 = new ArrayList<>();
		fruitsBasket2.add(new Banana());
		fruitsBasket2.add(new Orange());
		booksBasket1.add(new TextBook());
		copy(booksBasket1, fruitsBasket2);
//		System.out.println(fruitsBasket2);
		for ( Fruit f : fruitsBasket2 ) {
			System.out.println(f.getFruitName());
		}
	}

	public static <T, U> void copyGenerics(List<T> src, List<U> dest) {
		for (T t : src) {
			U u = (U) t;
			dest.add(u);
		}
	}
	
	public static void copy(List<Book> src, List<Fruit> dest) {
		for ( Object b : src ) {
			Fruit f = (Fruit) b;
			dest.add(f);
		}
	}
}

//
//https://levelup.gitconnected.com/how-to-design-a-system-to-scale-to-your-first-100-million-users-4450a2f9703d
//https://spring.io/guides
//https://stackoverflow.com/questions/tagged/spring
//https://jakarta.ee/specifications/platform/
//https://jakarta.ee/specifications/platform/8/platform-spec-8#jakarta-management
//https://cli.github.com/manual/gh_repo_create
//https://blog.jetbrains.com/idea/2020/08/jetbrains-technology-day-for-java-how-i-started-contributing-to-open-source-and-why-you-should-too/
//https://www.google.com/search?sca_esv=577401633&sxsrf=AM9HkKmt7OVHCjqgb64h1NFfZheAJ8Ch1Q:1698480410265&q=Best+open+source+Java+projects&stick=H4sIAAAAAAAAAOOQMZJLSi0uUcgvSM1TKM4vLUpOVchKLEtUKCjKz0pNLimOUk_OzyspykwqLUlVKMmHSCKrhik8xciln6tvkGFmUpyeBOUUppWZGmZBOUnmFgaVyacYOUGc5DQTi4pfjHJO6JZ7IVvewMK4iJWAmltskgwHrmQuET-1sJL3TPaPv4Y_5lhXK7k--PevDABrBsQE3wAAAA&sa=X&ved=2ahUKEwiCzIvMpJiCAxVvsFYBHadsB9IQ4qYDegQIJhAG
//https://medium.com/issuehunt/50-top-java-projects-on-github-adbfe9f67dbc
//https://github.com/square/retrofit/tree/master
//https://github.com/elastic/elasticsearch
//https://github.com/reactive-streams/reactive-streams-jvm
//https://www.reactive-streams.org/
//https://github.com/Reactive-Extensions/RxJS
//https://github.com/ReactiveX/rxjs
//https://www.upgrad.com/blog/java-open-source-projects/
//https://github.com/iluwatar/java-design-patterns/blob/master/pom.xml
//https://jenkov.com/tutorials/java-performance/jmh.html
//https://github.com/eugenp/tutorials/blob/master/jmh/src/main/resources/logback.xml
//https://medium.com/javarevisited/understanding-java-microbenchmark-harness-or-jmh-tool-5b9b90ccbe8d
//https://github.com/nipafx/demo-jpms-monitor
//https://www.youtube.com/watch?v=JLFjY6Ixct8&t=1020s
//https://www.youtube.com/watch?app=desktop&v=a-U0so9FfqQ
//https://nofluffjuststuff.com/#schedule
//https://www.linkedin.com/in/dougqh/
//https://www.google.com/search?sca_esv=582545254&sxsrf=AM9HkKkq-uH5ekpCn0NH__eq0Tfx5pqi-A:1700037379811&q=jvm+startingup+graph&tbm=isch&chips=q:jvm+starting+up+graph,online_chips:flame+graph:HFheDprhyIg%3D&usg=AI4_-kRjyxhknms-WQp2hbq_3rO_bdWfNw&sa=X&ved=2ahUKEwjFkIPhzMWCAxVDamwGHT7sACIQgIoDKAB6BAgTEBI&biw=1501&bih=742&dpr=2
//https://github.com/BrendanGregg/FlameGraph
//https://github.com/dougqh/jvm-mechanics/blob/master/src/example01a/SimpleProgram.java
//https://github.com/mtumilowicz/jit-notes
//https://github.com/AdoptOpenJDK/jitwatch
//https://skillsmatter.com/skillscasts/5243-chris-newland-hotspot-profiling-with-jit-watch
//chrome-extension://efaidnbmnnnibpcajpcglclefindmkaj/https://www.chrisnewland.com/images/jitwatch/HotSpot_Profiling_Using_JITWatch.pdf
//https://www.chrisnewland.com/building-hsdis-on-linux-amd64-on-debian-369
//https://www.youtube.com/feed/history
//https://www.youtube.com/watch?v=F73kB4XZQ4I&t=1575s
//https://github.com/deephacks/awesome-jvm#profilers
//https://www.youtube.com/results?search_query=jitwatch
//https://www.youtube.com/watch?v=SNCXp5ilYaA&t=8781s
//https://www.youtube.com/watch?v=QnMDsI2GbOc&list=PLX8CzqL3ArzUY6rQAQTwI_jKvqJxrRrP_
//https://www.youtube.com/watch?v=p7ipmAa9_9E
//https://www.google.com/search?q=jigsaw+java&oq=jigsaw+ja&gs_lcrp=EgZjaHJvbWUqBwgAEAAYgAQyBwgAEAAYgAQyBggBEEUYOTIHCAIQABiABDIHCAMQABiABDIHCAQQABiABDIHCAUQABiABDIHCAYQABiABDIHCAcQABiABDIHCAgQLhiABDIHCAkQABiABKgCALACAA&sourceid=chrome&ie=UTF-8
//https://openjdk.org/projects/jigsaw/
//https://twitter.com/Java_Champions
//https://javachampions.org/stats.html
//https://jbake.org/
//https://blogs.oracle.com/java/category/j-java-champions
//https://vladmihalcea.com/how-to-become-a-java-champion/
//https://www.eclipsecon.org/2022/sessions/life-java-champion%E2%80%A6-and-how-become-one
//chrome://extensions/?id=djdmadneanknadilpjiknlnanaolmbfk
//
//	
//	
//	https://docs.spring.io/spring-framework/docs/
//		chrome-extension://efaidnbmnnnibpcajpcglclefindmkaj/https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/pdf/spring-framework-reference.pdf
//		https://dev.to/__nikolamicic21/multiple-hierarchical-contexts-in-spring-boot-25nf
//		https://www.digitalocean.com/community/tutorials/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations
//		https://www.digitalocean.com/community/tutorials/spring-jdbc-example
//		https://www.youtube.com/results?search_query=+java+8
//		https://www.baeldung.com/java-8-new-features
//		https://www.youtube.com/watch?v=YnzisJh-ZNI&t=54s
//		https://victorrentea.ro/#contact
//		file:///Users/vinodkumarm/Downloads/CV-Victor-Rentea.EN.pdf
//		https://beanvalidation.org/1.0/spec/
//		https://github.com/victorrentea/functional-patterns-bjug-2018/blob/1ef8f39bfe39d3bff27f76a8250c3fd64ab002ad/src/main/java/victor/clean/lambdas/B__Stream_Wrecks.java
//		https://www.mysqltutorial.org/mysql-sample-database.aspx
//		https://www.volkswagen.co.in/en/models/taigun.html?campaign=00012777%7cTaigunSearch&language=EN&adchan=seah&publisher=GADW&country=IN&adplt=pseac&cpid=00012777%7cNU&adver=NU&format=Mixed&adpay=pd&adcta=NU&adaud=NU&adpl=NU&adcr=NU&adgroup=EvaluationExact&seatype=Branded&adap=ca2%7cTaigunSearchNov23-191-cdtai&adchan=sem&campaign=01955290_NC_IMC_BON_CON_TAI_VWB_CUV_IND_NU_SEAH_PSEAC_APPA_NU_GAD_GADW_CPC_NU_BDS_KEW_A18-40_CXD_EN_EX_BRAD_%23CI-55707002786-1-Taigun-Exact&adgroup=Taigun+Exact&publisher=GOOGLE&adcr=taigun&adpl=GOOGLE&adlid=71700000078731842&country=IN&language=EN&gad_source=1&gclid=Cj0KCQiAr8eqBhD3ARIsAIe-buPfGoN5YuJ8-tqjRlwBnGgfVM-x3XhQp5Pkl6meflGl4U3gqWvkTrQaAqH0EALw_wcB&gclsrc=aw.ds
//		https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html
//		https://www.youtube.com/watch?v=yddwA3458eo&t=812s
//		https://github.com/JosePaumard/devoxx-be-2017/blob/master/src/main/java/org/paumard/devoxx2017/part1/Devoxx2017E.java
//		https://www.slideshare.net/jpaumard/collectors-in-the-wild
//		https://dev.mysql.com/doc/sakila/en/sakila-usage.html
//		https://github.com/search?q=ClassLoader&type=repositories
//		https://github.com/projectlombok/lombok/tree/214665bd440ed0c611258ddc2cd610bce56e0fcb
//		https://github.com/sbt/sbt/tree/fb8ca26e77d495cf206a45025a63c9a6d0754a9f
//		https://jboss-modules.github.io/jboss-modules/manual/
//		https://github.com/neo4j/neo4j/tree/60f235e37443d4820c5c5c2a251a4096cf18a430
//		https://blogs.oracle.com/java/post/prepare-for-jdk-9
//		https://www.youtube.com/results?search_query=java+9
//		https://www.youtube.com/watch?v=22OW5t_Mbnk
//		https://www.youtube.com/watch?v=YnzisJh-ZNI&t=939s
//		https://www.volkswagen.co.in/en/models/taigun.html
//		https://stackoverflow.com/questions/53240219/is-the-jlink-module-path-an-ordered-path
//		https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/addressing-merge-conflicts/resolving-a-merge-conflict-using-the-command-line
//		https://docs.oracle.com/en/java/javase/11/tools/jlink.html#GUID-CECAC52B-CFEE-46CB-8166-F17A8E9280E9
//		https://docs.oracle.com/javase/8/docs/technotes/tools/#basic
//
//			
//			
//			https://www.google.com/search?q=software+architect&oq=software+archi&gs_lcrp=EgZjaHJvbWUqCQgAECMYJxiKBTIJCAAQIxgnGIoFMgYIARBFGDkyCggCEAAYsQMYgAQyBwgDEAAYgAQyBwgEEAAYgAQyBwgFEC4YgAQyBwgGEAAYgAQyBwgHEC4YgAQyBwgIEAAYgAQyBwgJEAAYgATSAQg0NTYzajBqN6gCALACAA&sourceid=chrome&ie=UTF-8
//				https://github.com/search?q=system+design&type=repositories&s=stars&o=desc
//				https://github.com/donnemartin/system-design-primer
//				https://github.com/ByteByteGoHq/system-design-101#cache
//				https://github.com/search?q=react&type=repositories&s=stars&o=desc&p=1
//				https://github.com/search?q=angular&type=repositories&s=stars&o=desc
//				https://github.com/search?q=flutter&type=repositories
//				https://docs.spring.io/spring-framework/docs/1.2.x/reference/jdbc.html
//				https://github.com/search?q=javascript&type=repositories&s=stars&o=desc
//				https://github.com/trekhleb/javascript-algorithms/tree/master/src/data-structures/linked-list
//				https://contribute.freecodecamp.org/#/how-to-setup-freecodecamp-locally
//				https://www.mongodb.com/docs/manual/tutorial/install-mongodb-enterprise-on-os-x/
//				https://pnpm.io/installation
//				https://gist.github.com/chranderson/b0a02781c232f170db634b40c97ff455
//				https://github.com/spring-projects/spring-framework/wiki/Build-from-Source
//				https://developers.redhat.com/products/eap/getting-started?success=true&tcWhenSigned=January+1%2C+1970&tcWhenEnds=January+1%2C+1970&tcEndsIn=0&tcDuration=365&tcDownloadFileName=jboss-eap-7.4.0-src.zip&tcRedirect=5000&tcSrcLink=https%3A%2F%2Fdevelopers.redhat.com%2Fcontent-gateway%2Fcontent%2Forigin%2Ffiles%2Fsha256%2F7c%2F7c0500b2f68a9884aa3bd2d17f6fecc83505bffeb647a9c1843ce48eb2c6f766%2Fjboss-eap-7.4.0-src.zip&p=SPMM%3A+Enterprise+Application+Platform&pv=7.4.0&tcDownloadURL=https%3A%2F%2Faccess.cdn.redhat.com%2Fcontent%2Forigin%2Ffiles%2Fsha256%2F7c%2F7c0500b2f68a9884aa3bd2d17f6fecc83505bffeb647a9c1843ce48eb2c6f766%2Fjboss-eap-7.4.0-src.zip%3F_auth_%3D1698811623_8a7a9d5fa728c3148b294ce1be4dcc1c
//				https://docs.oracle.com/javaee/7/tutorial/jms-concepts002.htm
//				https://howtodoinjava.com/spring-boot/spring-boot-jmstemplate-activemq/
//				https://activemq.apache.org/components/artemis/documentation/latest/examples.html#running-the-examples
//				https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
//				https://activemq.apache.org/components/artemis/documentation/2.18.0/messaging-concepts.html
//				https://web.archive.org/web/20061130103858/http://weblogs.java.net/blog/enicholas/archive/2006/05/understanding_w.html
//				https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/ref/WeakReference.html
//				https://www.cs.fsu.edu/~jtbauer/cis3931/tutorial/refobjs/about/weak.html
//				https://www.google.com/search?q=java+weak+reference&sca_esv=580414175&tbm=isch&sxsrf=AM9HkKnxs5kiz5srgfXkYilDcQ3D2H5meg:1699440206017&source=lnms&sa=X&ved=2ahUKEwjvpK-OnLSCAxU5SGwGHX2tA9QQ_AUoAXoECAEQAw&biw=1501&bih=742&dpr=2#imgrc=-mJs-zYgasLLeM
//				https://antkorwin.com/gc/autodeletable_temp_files_in_java_eng.html
//				https://github.com/antkorwin/common-utils/tree/master
//				https://java-latte.blogspot.com/2014/07/difference-between-StrongReference-WeakReference-SoftReference-PhantomReference-in-java.html
//				https://www.herongyang.com/JVM/Memory-Java-Exception-Out-of-Memory-Error.html
//				https://github.com/ScottOaks/JavaPerformanceTuning/blob/master/FirstEdition/README
//				https://github.com/openjdk/jmh/blob/master/jmh-core/src/main/java/org/openjdk/jmh/runner/BenchmarkList.java
//				https://github.com/shekhargulati/strman-java/tree/master
//				https://github.com/aNNiMON/Lightweight-Stream-API/tree/master
//				https://github.com/RichardWarburton/java-8-lambdas-exercises/tree/master
//				https://www.oracle.com/java/technologies/ma14-java-se-8-streams.html
//				https://www.google.com/search?q=java+8+streams+structure&sca_esv=582945116&tbm=isch&sxsrf=AM9HkKkMnM8cbK3l20hZFamQ0X4kOc-k6g:1700145874247&source=lnms&sa=X&ved=2ahUKEwjZ-Zn34MiCAxXjTmwGHeRaBysQ_AUoAXoECAMQAw&biw=1501&bih=742&dpr=2#imgrc=87XClJeN8-ZUSM
//				https://stackabuse.com/java-8-streams-guide-to-parallel-streaming-with-parallel/
//				https://en.wikipedia.org/wiki/MapReduce
//				https://www.youtube.com/watch?v=LEAoMMEIUXk&t=1676s
//				https://github.com/RichardWarburton/generics-examples/blob/master/src/main/java/_2_intersection_types/samples/BinaryCompatibility.java
//				https://github.com/iluwatar/java-design-patterns/tree/master/visitor
//				https://refactoring.guru/design-patterns/visitor/java/example
//				https://sourcemaking.com/design-patterns-ebook#checkout/paysystems
//				http://www.angelikalanger.com/GenericsFAQ/FAQSections/TypeArguments.html#FAQ103
//				https://stackoverflow.com/questions/2776975/how-can-i-add-to-list-extends-number-data-structures/2777297#2777297
//				https://www.baeldung.com/java-generics-vs-extends-object
//				https://docs.oracle.com/javase/tutorial/java/generics/genTypes.html
//				https://docs.oracle.com/javase/tutorial/java/generics/nonReifiableVarargsType.html
//				https://docs.oracle.com/javase/tutorial/extra/generics/convert.html
//				https://www.baeldung.com/java-collections
//				https://docs.oracle.com/javase/tutorial/java/generics/upperBounded.html
//				https://www.youtube.com/watch?v=D5HEshszlPE&list=PLkiVxfkxAYd2TAn--1BH1ERvYbHxh11Qs
//
//					
//					https://docs.spring.io/spring-framework/docs/
//						chrome-extension://efaidnbmnnnibpcajpcglclefindmkaj/https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/pdf/spring-framework-reference.pdf
//						https://dev.to/__nikolamicic21/multiple-hierarchical-contexts-in-spring-boot-25nf
//						https://www.digitalocean.com/community/tutorials/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations
//						https://www.digitalocean.com/community/tutorials/spring-jdbc-example
//						https://www.youtube.com/results?search_query=+java+8
//						https://www.baeldung.com/java-8-new-features
//						https://www.youtube.com/watch?v=YnzisJh-ZNI&t=54s
//						https://victorrentea.ro/#contact
//						file:///Users/vinodkumarm/Downloads/CV-Victor-Rentea.EN.pdf
//						https://beanvalidation.org/1.0/spec/
//						https://github.com/victorrentea/functional-patterns-bjug-2018/blob/1ef8f39bfe39d3bff27f76a8250c3fd64ab002ad/src/main/java/victor/clean/lambdas/B__Stream_Wrecks.java
//						https://www.mysqltutorial.org/mysql-sample-database.aspx
//						https://www.volkswagen.co.in/en/models/taigun.html?campaign=00012777%7cTaigunSearch&language=EN&adchan=seah&publisher=GADW&country=IN&adplt=pseac&cpid=00012777%7cNU&adver=NU&format=Mixed&adpay=pd&adcta=NU&adaud=NU&adpl=NU&adcr=NU&adgroup=EvaluationExact&seatype=Branded&adap=ca2%7cTaigunSearchNov23-191-cdtai&adchan=sem&campaign=01955290_NC_IMC_BON_CON_TAI_VWB_CUV_IND_NU_SEAH_PSEAC_APPA_NU_GAD_GADW_CPC_NU_BDS_KEW_A18-40_CXD_EN_EX_BRAD_%23CI-55707002786-1-Taigun-Exact&adgroup=Taigun+Exact&publisher=GOOGLE&adcr=taigun&adpl=GOOGLE&adlid=71700000078731842&country=IN&language=EN&gad_source=1&gclid=Cj0KCQiAr8eqBhD3ARIsAIe-buPfGoN5YuJ8-tqjRlwBnGgfVM-x3XhQp5Pkl6meflGl4U3gqWvkTrQaAqH0EALw_wcB&gclsrc=aw.ds
//						https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html
//						https://www.youtube.com/watch?v=yddwA3458eo&t=812s
//						https://github.com/JosePaumard/devoxx-be-2017/blob/master/src/main/java/org/paumard/devoxx2017/part1/Devoxx2017E.java
//						https://www.slideshare.net/jpaumard/collectors-in-the-wild
//						https://dev.mysql.com/doc/sakila/en/sakila-usage.html
//						https://github.com/search?q=ClassLoader&type=repositories
//						https://github.com/projectlombok/lombok/tree/214665bd440ed0c611258ddc2cd610bce56e0fcb
//						https://github.com/sbt/sbt/tree/fb8ca26e77d495cf206a45025a63c9a6d0754a9f
//						https://jboss-modules.github.io/jboss-modules/manual/
//						https://github.com/neo4j/neo4j/tree/60f235e37443d4820c5c5c2a251a4096cf18a430
//						https://blogs.oracle.com/java/post/prepare-for-jdk-9
//						https://www.youtube.com/results?search_query=java+9
//						https://www.youtube.com/watch?v=22OW5t_Mbnk
//						https://www.youtube.com/watch?v=YnzisJh-ZNI&t=939s
//						https://www.volkswagen.co.in/en/models/taigun.html
//						https://stackoverflow.com/questions/53240219/is-the-jlink-module-path-an-ordered-path
//						https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/addressing-merge-conflicts/resolving-a-merge-conflict-using-the-command-line
//						https://docs.oracle.com/en/java/javase/11/tools/jlink.html#GUID-CECAC52B-CFEE-46CB-8166-F17A8E9280E9
//						https://docs.oracle.com/javase/8/docs/technotes/tools/#basic
