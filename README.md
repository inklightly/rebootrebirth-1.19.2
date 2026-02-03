# Notes

Minor fixes for speeding up the boot of certain mods/resolving crashes.
A lot of these were just race condition fixes.

## Mods targeted:
- mutantmore-1.19.2-early_access-2.0.0.jar
- occultism-1.19.2-1.90.0.jar
- letsdo-vinery-forge-1.3.12.jar
- letsdo-bakery-forge-1.0.6.jar
- letsdo-candlelight-forge-1.1.9.jar
- letsdo-beachparty-forge-1.0.12.jar

## Stacktraces:

<details markdown="1"><summary>MutantMore.</summary>
&ensp;Details:  <br>
&emsp;Mod File: /home/********/mods/mutantmore-1.19.2-early_access-2.0.0.jar  <br/>
&emsp;Failure message: Mutant More (mutantmore) encountered an error during the common_setup event phase  <br/>
&emsp;&emsp;java.lang.ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 10  <br/>
&emsp;Mod Version: 1.0.0  <br/>
&emsp;Mod Issue URL: https://discord.gg/5qJDj9TxfF  <br/>
&emsp;Exception message: java.lang.ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 10  <br/>
Stacktrace:  <br/>
&emsp;at java.util.ArrayList.add(ArrayList.java:455) ~[?:?] {re:mixin}  <br/>
&emsp;at java.util.ArrayList.add(ArrayList.java:467) ~[?:?] {re:mixin}  <br/>
&emsp;at net.minecraftforge.common.brewing.BrewingRecipeRegistry.addRecipe(BrewingRecipeRegistry.java:49) ~[forge-1.19.2-43.5.0-universal.jar%23491!/:?]  <br/>{re:mixin,re:classloading,pl:mixin:APP:origins_classes.mixins.json:common.minecraft.BrewingRecipeRegistryMixin,pl:mixin:A}  <br/>
&emsp;at com.alexander.mutantmore.MutantMore.commonSetup(MutantMore.java:135) ~[mutantmore-1.19.2-early_access-2.0.0.jar%23412!/:1.0.0] {re:classloading}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.doCastFilter(EventBus.java:260) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.lambda$addListener$11(EventBus.java:252) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:315) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:296) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.javafmlmod.FMLModContainer.acceptEvent(FMLModContainer.java:121) ~[javafmllanguage-1.19.2-43.5.0.jar%23488!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.ModContainer.lambda$buildTransitionHandler$5(ModContainer.java:125) ~[fmlcore-1.19.2-43.5.0.jar%23487!/:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.exec(CompletableFuture.java:1796) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1182) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1655) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1622) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:165) ~[?:?] {re:mixin}  <br/>
</details>

<details markdown="1"><summary>Occultism</summary>
&ensp;Details:  <br/>
&emsp;Mod File: /home/********/mods/occultism-1.19.2-1.90.0.jar  <br/>
&emsp;Failure message: Occultism (occultism) encountered an error during the common_setup event phase  <br/>
&emsp;&emsp;java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 257  <br/>
&emsp;Mod Version: 1.90.0  <br/>
&emsp;Mod Issue URL: https://github.com/klikli-dev/occultism/issues  <br/>
&emsp;Exception message: java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 257  <br/>
Stacktrace:  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.rehash(Object2FloatOpenHashMap.java:1388) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.insert(Object2FloatOpenHashMap.java:278) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.put(Object2FloatOpenHashMap.java:286) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at com.klikli_dev.occultism.registry.OccultismItems.registerCompostables(OccultismItems.java:425) ~[occultism-1.19.2-1.90.0.jar%23427!/:1.90.0] {re:classloading}  <br/>
&emsp;at com.klikli_dev.occultism.Occultism.commonSetup(Occultism.java:120) ~[occultism-1.19.2-1.90.0.jar%23427!/:1.90.0] {re:classloading}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.doCastFilter(EventBus.java:260) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.lambda$addListener$11(EventBus.java:252) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:315) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:296) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.javafmlmod.FMLModContainer.acceptEvent(FMLModContainer.java:121) ~[javafmllanguage-1.19.2-43.5.0.jar%23490!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.ModContainer.lambda$buildTransitionHandler$5(ModContainer.java:125) ~[fmlcore-1.19.2-43.5.0.jar%23489!/:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.exec(CompletableFuture.java:1796) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1182) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1655) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1622) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:165) ~[?:?] {re:mixin}  <br/>
</details>

<details markdown="1"><summary>[Let's Do] Vinery</summary>
&ensp;Details:  <br/>
&emsp;Mod File: /home/********/mods/letsdo-vinery-forge-1.3.12.jar  <br/>
&emsp;Failure message: Vinery (vinery) encountered an error during the common_setup event phase  <br/>
&emsp;&emsp;java.util.ConcurrentModificationException: null  <br/>
&emsp;Mod Version: 1.3.12  <br/>
&emsp;Mod Issue URL: NOT PROVIDED  <br/>
&emsp;Exception message: java.util.ConcurrentModificationException  <br/>
Stacktrace:  <br/>
&emsp;at java.util.HashMap$HashIterator.nextNode(HashMap.java:1597) ~[?:?] {}  <br/>
&emsp;at java.util.HashMap$EntryIterator.next(HashMap.java:1630) ~[?:?] {}  <br/>
&emsp;at java.util.HashMap$EntryIterator.next(HashMap.java:1628) ~[?:?] {}  <br/>
&emsp;at java.util.HashMap.putMapEntries(HashMap.java:511) ~[?:?] {re:mixin}  <br/>
&emsp;at java.util.HashMap.<init>(HashMap.java:484) ~[?:?] {re:mixin}  <br/>
&emsp;at dev.architectury.hooks.item.tool.AxeItemHooks.addStrippable(AxeItemHooks.java:52) ~[architectury-6.6.92-forge.jar%23298!/:?] {re:classloading}  <br/>
&emsp;at satisfyu.vinery.Vinery.commonSetup(Vinery.java:42) ~[letsdo-vinery-forge-1.3.12.jar%23391!/:?] {re:classloading}  <br/>
&emsp;at satisfyu.vinery.forge.VineryForge.commonSetup(VineryForge.java:34) ~[letsdo-vinery-forge-1.3.12.jar%23391!/:?] {re:classloading}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.doCastFilter(EventBus.java:260) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.lambda$addListener$11(EventBus.java:252) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:315) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:296) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.javafmlmod.FMLModContainer.acceptEvent(FMLModContainer.java:121) ~[javafmllanguage-1.19.2-43.5.0.jar%23488!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.ModContainer.lambda$buildTransitionHandler$5(ModContainer.java:125) ~[fmlcore-1.19.2-43.5.0.jar%23487!/:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.exec(CompletableFuture.java:1796) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1182) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1655) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1622) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:165) ~[?:?] {re:mixin}  <br/>
</details>

<details markdown="1"><summary>[Let's Do] Bakery</summary>
&ensp;Details:  <br/>
&emsp;Mod File: /home/********/mods/letsdo-bakery-forge-1.0.6.jar  <br/>
&emsp;Failure message: Bakery (bakery) encountered an error during the common_setup event phase  <br/>
&emsp;java.lang.ArrayIndexOutOfBoundsException: Index 512 out of bounds for length 257  <br/>
&emsp;Mod Version: 1.0.6  <br/>
&emsp;Mod Issue URL: NOT PROVIDED  <br/>
&emsp;Exception message: java.lang.ArrayIndexOutOfBoundsException: Index 512 out of bounds for length 257  <br/>
Stacktrace:  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.rehash(Object2FloatOpenHashMap.java:1394) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.insert(Object2FloatOpenHashMap.java:278) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.put(Object2FloatOpenHashMap.java:286) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at satisfy.bakery.registry.CompostableRegistry.init(CompostableRegistry.java:22) ~[letsdo-bakery-forge-1.0.6.jar%23388!/:?] {re:classloading}  <br/>
&emsp;at satisfy.bakery.Bakery.commonInit(Bakery.java:30) ~[letsdo-bakery-forge-1.0.6.jar%23388!/:?] {re:classloading}  <br/>
&emsp;at satisfy.bakery.forge.BakeryForge.commonSetup(BakeryForge.java:20) ~[letsdo-bakery-forge-1.0.6.jar%23388!/:?] {re:classloading}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.doCastFilter(EventBus.java:260) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.lambda$addListener$11(EventBus.java:252) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:315) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:296) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.javafmlmod.FMLModContainer.acceptEvent(FMLModContainer.java:121) ~[javafmllanguage-1.19.2-43.5.0.jar%23490!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.ModContainer.lambda$buildTransitionHandler$5(ModContainer.java:125) ~[fmlcore-1.19.2-43.5.0.jar%23489!/:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.exec(CompletableFuture.java:1796) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1182) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1655) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1622) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:165) ~[?:?] {re:mixin}  
</details>

<details markdown="1"><summary>[Let's Do] Candlelight</summary>
&ensp;Details:  <br/>
&emsp;Mod File: /home/********/mods/letsdo-candlelight-forge-1.1.9.jar  <br/>
&emsp;Failure message: Candlelight Dinner (candlelight) encountered an error during the common_setup event phase  <br/>
&emsp;&emsp;java.lang.ArrayIndexOutOfBoundsException: Index 512 out of bounds for length 257  <br/>
&emsp;Mod Version: 1.1.9  <br/>
&emsp;Mod Issue URL: NOT PROVIDED  <br/>
&emsp;Exception message: java.lang.ArrayIndexOutOfBoundsException: Index 512 out of bounds for length 257  <br/>
Stacktrace:  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.rehash(Object2FloatOpenHashMap.java:1394) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.insert(Object2FloatOpenHashMap.java:278) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.put(Object2FloatOpenHashMap.java:286) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at satisfyu.candlelight.registry.CompostableRegistry.init(CompostableRegistry.java:8) ~[letsdo-candlelight-forge-1.1.9.jar%23385!/:?] {re:classloading}  <br/>
&emsp;at satisfyu.candlelight.Candlelight.commonInit(Candlelight.java:29) ~[letsdo-candlelight-forge-1.1.9.jar%23385!/:?] {re:classloading}  <br/>
&emsp;at satisfyu.candlelight.forge.CandlelightForge.commonSetup(CandlelightForge.java:20) ~[letsdo-candlelight-forge-1.1.9.jar%23385!/:?] {re:classloading}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.doCastFilter(EventBus.java:260) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.lambda$addListener$11(EventBus.java:252) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:315) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:296) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.javafmlmod.FMLModContainer.acceptEvent(FMLModContainer.java:121) ~[javafmllanguage-1.19.2-43.5.0.jar%23484!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.ModContainer.lambda$buildTransitionHandler$5(ModContainer.java:125) ~[fmlcore-1.19.2-43.5.0.jar%23483!/:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.exec(CompletableFuture.java:1796) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1182) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1655) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1622) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:165) ~[?:?] {re:mixin}  <br/>
</details>

<details markdown="1"><summary>[Let's Do] Beachparty</summary>
&ensp;Details:  <br/>
&emsp;Mod File: /home/********/mods/letsdo-beachparty-forge-1.0.12.jar  <br/>
&emsp;Failure message: Beachparty (beachparty) encountered an error during the common_setup event phase  <br/>
&emsp;&emsp;java.lang.ArrayIndexOutOfBoundsException: Index 512 out of bounds for length 257  <br/>
&emsp;Mod Version: 1.0.12  <br/>
&emsp;Mod Issue URL: NOT PROVIDED  <br/>
&emsp;Exception message: java.lang.ArrayIndexOutOfBoundsException: Index 512 out of bounds for length 257  <br/>
Stacktrace:  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.rehash(Object2FloatOpenHashMap.java:1394) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.insert(Object2FloatOpenHashMap.java:278) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap.put(Object2FloatOpenHashMap.java:286) ~[fastutil-8.5.6.jar%2395!/:?] {}  <br/>
&emsp;at satisfyu.beachparty.registry.CompostablesRegistry.registerCompostableItem(CompostablesRegistry.java:23) ~[letsdo-beachparty-forge-1.0.12.jar%23388!/:?] {re:classloading}  <br/>
&emsp;at satisfyu.beachparty.registry.CompostablesRegistry.init(CompostablesRegistry.java:11) ~[letsdo-beachparty-forge-1.0.12.jar%23388!/:?] {re:classloading}  <br/>
&emsp;at satisfyu.beachparty.Beachparty.commonSetup(Beachparty.java:34) ~[letsdo-beachparty-forge-1.0.12.jar%23388!/:?] {re:classloading}  <br/>
&emsp;at satisfyu.beachparty.forge.BeachpartyForge.commonSetup(BeachpartyForge.java:23) ~[letsdo-beachparty-forge-1.0.12.jar%23388!/:?] {re:classloading}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.doCastFilter(EventBus.java:260) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.lambda$addListener$11(EventBus.java:252) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:315) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.eventbus.EventBus.post(EventBus.java:296) ~[eventbus-6.0.3.jar%2352!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.javafmlmod.FMLModContainer.acceptEvent(FMLModContainer.java:121) ~[javafmllanguage-1.19.2-43.5.0.jar%23488!/:?] {}  <br/>
&emsp;at net.minecraftforge.fml.ModContainer.lambda$buildTransitionHandler$5(ModContainer.java:125) ~[fmlcore-1.19.2-43.5.0.jar%23487!/:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.CompletableFuture$AsyncRun.exec(CompletableFuture.java:1796) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1182) ~[?:?] {}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1655) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1622) ~[?:?] {re:mixin,re:computing_frames}  <br/>
&emsp;at java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:165) ~[?:?] {re:mixin}  <br/>
</details>
