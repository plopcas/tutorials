public class FilePaths {

    private Path duplicatePath;
    private Path originalPath;

    public FilePaths(Path duplicatePath, Path originalPath) {
        this.duplicatePath = duplicatePath;
        this.originalPath = originalPath;
    }

    public Path getDuplicatePath() {
        return duplicatePath;
    }

    public Path getOriginalPath() {
        return originalPath;
    }

}

public class FindDuplicateFiles {
    public List<FilePaths> findDuplicates() {

        List<FilePaths> result = new ArrayList<>();

        List<Path> paths = FileUtils.scanFrom("/");

        Map<String, Path> seenFiles = new HashMap<>();
        for (Path path : paths) {
            String currentFileHash = Hasher.hash(path.toFile()); // Method that creates a hash from the file contents
            if (seenFiles.containsKey(currentFileHash) != null) {
                File file1 = path.toFile();
                File file2 = seenFiles.get(currentFileHash).toFile();
                if (file1.lastModified() > file2.lastModified()) {
                    result.add(new FilePaths(file2.toPath(), file1.toPath()));
                } else {
                    result.add(new FilePaths(file1.toPath(), file2.toPath()));
                }
            } else {
                seenPaths.put(currentFileHash, path);
            }
        }

        return result;
    }
}