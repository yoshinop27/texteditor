# CSC 207: Text Editor

**Author**: Preston, Reo

## Resources Used

+ https://docs.oracle.com/javase/8/docs/api/index.html?java/nio/file/Files.html
+ https://mabe02.github.io/lanterna/apidocs/3.1/overview-summary.html
+ ...

## Part 2

In our String back text buffer, for the insert method we consider our relavant operation to be the reassignment of simpleStringBuffer. In this reassignment we assign 2 substrings and one character to simpleStringBuffer. We can analyze the time complexity with the funciton T(n) where n represents the length of simpleStringBuffer. T(n)=n+1. This is because we are copying our old string and the new character into new memory that gets reassigned to simpleStringBuffer. Because strings are immutable, we can't modify that original memory space, thus we have to obtain new memory to hold our new string, and write in n+1 characters to that new memory which gets assigned to simpleStringBuffer. Thus we classify this operation O(n). We can see how this becomes wasteful as n grows larger.

## Changelog

commit 43e1b145ccc042c597d1a217be78f7024c5656c8 (HEAD -> main, origin/main)
Merge: 8fda5ee 05152f5
Author: Preston Yoshino <prestonyoshino@Mac.grinnell.edu>
Date:   Fri Oct 3 18:37:07 2025 -0500

    Merge branch 'preston-changes'

commit 05152f54bb3206b062da0d57e98b2aa5d71bf45f (origin/preston-changes, preston-changes)
Author: Preston Yoshino <prestonyoshino@Mac.grinnell.edu>
Date:   Fri Oct 3 17:26:51 2025 -0500

    changed cursor functionality

commit 8fda5eee17d2fe121edd152b9df27d7434c216fd
Author: Preston Yoshino <prestonyoshino@Mac.grinnell.edu>
Date:   Fri Oct 3 17:22:04 2025 -0500

    changed cursor functionality

commit 5ee0c0540e89d2767f32228c334a9f0ffd07a94f
Author: Preston Yoshino <prestonyoshino@Mac.grinnell.edu>
Date:   Sun Sep 28 14:45:16 2025 -0500

    final

commit d705bd80ce019e605b85238a60480236afdc5a37 (HEAD -> preston-changes, origin/preston-changes)
Author: Preston Yoshino <prestonyoshino@Mac.grinnell.edu>
Date:   Sun Sep 28 14:40:13 2025 -0500

    final implementation tui runs in terminal

commit 480fd8a3fd27184e99d566d4d23d3d71b0edd01b
Author: Preston Yoshino <prestonyoshino@Mac.grinnell.edu>
Date:   Sun Sep 28 14:37:07 2025 -0500

    Working through tui

commit 06ab8b031478224d9078958c415cd2ad3754b259
Author: Preston Yoshino <prestonyoshino@Mac.grinnell.edu>
Date:   Sun Sep 28 12:16:38 2025 -0500

    reworked part 3 to follow O(1) insertion

commit 3142c5239ec9f28ad2cda68a25e1662ae6f2659f (origin/main, main)
Author: reocraft <reocraft.creeper@gmail.com>
Date:   Sun Sep 28 03:06:30 2025 -0500

    Made minor big fix for when increasing array size of GapBuffer

commit 01637b2250cc91ae5c4dbb578448610ad7c2a565
Author: reocraft <reocraft.creeper@gmail.com>
Date:   Sun Sep 28 02:02:52 2025 -0500

    Part 3 completed

commit cefdad9997facf4e38f3f1c1b60f12f0aa56d624
Author: Preston Yoshino <prestonyoshino@Mac.grinnell.edu>
Date:   Sat Sep 27 23:13:14 2025 -0500

    finished part 2

commit f1883002289159e3c4633828477772275c6d3139
Author: Preston Yoshino <prestonyoshino@Mac.grinnell.edu>
Date:   Sat Sep 27 22:09:31 2025 -0500

    completed simplestringbuffer test suite

commit dbbea05bc718faa9d98f2bf2e2df7cc98cfb7ddf
Author: Preston Yoshino <prestonyoshino@Mac.grinnell.edu>
Date:   Sat Sep 27 21:50:10 2025 -0500

    implemented simplestringbuffer methods

commit 32a90495f40bd92ce905d4d78fbdab4dbaa6d5f9
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Thu Feb 13 12:40:05 2025 -0600